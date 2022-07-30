package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute.TrabajoImagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.dto.Mensaje;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Trabajo;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.CloudinaryService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.ImagenService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.TrabajoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import java.util.Map;


@RestController
// @CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="https://portfoliobackdiegodelias.herokuapp.com")
public class TrabajoController {

    @Autowired   
    private TrabajoService trabajoservice;

    
    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;


    // @PostMapping("/trabajos")
    @RequestMapping(path = "/trabajos", method = RequestMethod.POST,
    consumes = {"multipart/form-data"})
    public ResponseEntity<?>  saveTrabajo(@ModelAttribute TrabajoImagen trabajoimagen ) throws IOException{
        BufferedImage bi = ImageIO.read(trabajoimagen.getDocument().getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
         }
        Map result = cloudinaryService.upload(trabajoimagen.getDocument());
        Imagen imagen =
        new Imagen((String)result.get("original_filename"),
                (String)result.get("url"),
                (String)result.get("public_id"));

        Trabajo trabajo = new Trabajo();

        trabajo.setPuesto(trabajoimagen.getPuesto());
        trabajo.setEmpresa_nombre(trabajoimagen.getPuesto());
        trabajo.setPeriodo(trabajoimagen.getPeriodo());
        trabajo.setDescripcion(trabajoimagen.getDescripcion());
        trabajo.setIdimagen((String)result.get("public_id"));
        trabajo.setImagenurl((String)result.get("url"));


        trabajoservice.saveTrabajo(trabajo);

        imagenService.save(imagen);

        
        
        
        
        
        // return trabajoservice.saveTrabajo(trabajo);


        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
    }


    @GetMapping("/trabajos")
    public List<Trabajo> fetchTrabajoList() {

        return trabajoservice.fetchTrabajoList();

        
    }


    @GetMapping("/trabajos/{id}")
    public Trabajo fetchTrabajoById(@PathVariable("id") Long trabajoId){

        return trabajoservice.fetchTrabajoById(trabajoId);
    }


    @DeleteMapping("/trabajos/acciones/borrar/{id}")
    public void deleteTrabajoByid(@PathVariable("id") Long trabajoId) {

        trabajoservice.deleteTrabajoByid(trabajoId);
        // return "Registro trabajo  borrado correctamente";

    }

    
    @RequestMapping(path = "/trabajos/acciones/actualizar/{id}", method = RequestMethod.PUT,
    consumes = {"multipart/form-data"})
    public ResponseEntity<?>   updateTrabajo( @ModelAttribute TrabajoImagen trabajoimagen) throws IOException  {

        Integer id_Trabajo = Integer.parseInt(trabajoimagen.getTrabajoId());
        Long longId = Long.valueOf(id_Trabajo);
        System.out.println("long idddddd" + longId);
        Trabajo trabajoOriginal = trabajoservice.fetchTrabajoById(longId);
        Imagen im = imagenService.findByImagebyimagenId(trabajoOriginal.getIdimagen());
        String ImageId_Borrar = im.getImagenId();

        BufferedImage bi = ImageIO.read(trabajoimagen.getDocument().getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
         }

         Map result = cloudinaryService.upload(trabajoimagen.getDocument());
         im.setName((String)result.get("original_filename"));
         im.setImageUrl( (String)result.get("url"));
         im.setImagenId((String)result.get("public_id"));
         trabajoOriginal.setIdimagen((String)result.get("public_id"));
         trabajoOriginal.setImagenurl((String)result.get("url"));
         trabajoOriginal.setPuesto(trabajoimagen.getPuesto());
         trabajoOriginal.setEmpresa_nombre(trabajoimagen.getEmpresa_nombre());
         trabajoOriginal.setPeriodo(trabajoimagen.getPeriodo());
         trabajoOriginal.setDescripcion(trabajoimagen.getDescripcion());

         cloudinaryService.delete(ImageId_Borrar);

         imagenService.save(im);

         trabajoservice.updateTrabajo(trabajoOriginal.getTrabajoId(), trabajoOriginal);





        // return trabajoservice.updateTrabajo(trabajoId , trabajo);
        return new ResponseEntity(new Mensaje("imagen actualizada correctamente"), HttpStatus.OK);

    }

    

    @PutMapping("/trabajos/acciones/actualizar/sincambios/{id}")
    public Trabajo updateUsuario( @PathVariable("id") Long trabajoId, @RequestBody Trabajo trabajo) {

        return trabajoservice.updateTrabajo(trabajoId , trabajo);


    }

    
}
