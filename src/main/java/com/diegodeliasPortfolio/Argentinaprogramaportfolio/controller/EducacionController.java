package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;

import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute.EducacionImagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.dto.Mensaje;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Educacion;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.CloudinaryService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.EducacionService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.ImagenService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.awt.image.BufferedImage;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EducacionController {
    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;


    @Autowired
    private EducacionService educacionservice;
    
    @RequestMapping(path = "/educacion", method = RequestMethod.POST,
    consumes = {"multipart/form-data"})

    public ResponseEntity<?> saveEducacion(@ModelAttribute EducacionImagen educacionimagen) throws IOException{

        BufferedImage bi = ImageIO.read(educacionimagen.getDocument().getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
         }
         Map result = cloudinaryService.upload(educacionimagen.getDocument());
         Imagen imagen =
         new Imagen((String)result.get("original_filename"),
                 (String)result.get("url"),
                 (String)result.get("public_id"));
 
         Educacion educacion= new Educacion();
         educacion.setTitulonombre(educacionimagen.getTitulonombre());
         educacion.setNombreInstitucion(educacionimagen.getNombreInstitucion());
         educacion.setPeriodo(educacionimagen.getPeriodo());
         educacion.setInstitucion_url(educacionimagen.getInstitucion_url());
         educacion.setContenido(educacionimagen.getContenido());
         educacion.setIdimagen((String)result.get("public_id"));
         educacion.setImagenurl((String)result.get("url"));
 




        educacionservice.saveEducacion(educacion);

        imagenService.save(imagen);

        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
    }

    @GetMapping("/educacion")
    public List<Educacion> fetchEducacionList() {

        return educacionservice.fetchEducacionList();

        
    }
    
    @GetMapping("/educacion/{id}")
    public Educacion fetchEducacionById(@PathVariable("id") Long educacionId){

        return educacionservice.fetchEducacionById(educacionId);
    }

    @DeleteMapping("/educacion/acciones/borrar/{id}")
    public void deleteEducacionByid(@PathVariable("id") Long educacionId) {

        educacionservice.deleteUsuarioByid(educacionId);
    

    }

    // @PutMapping("/educacion/{id}")
    // public Educacion updateEducacion( @PathVariable("id") Long educacionId, @RequestBody Educacion educacion) {

    //     return educacionservice.updateEducacion(educacionId , educacion);


    // }

    @RequestMapping(path = "/educacion/acciones/actualizar/{id}", method = RequestMethod.PUT,
    consumes = {"multipart/form-data"})
    public ResponseEntity<?>   updateTrabajo( @ModelAttribute EducacionImagen educacionimagen) throws IOException  {

        Integer id_Educacion = Integer.parseInt(educacionimagen.getEducacionId());
        Long longId = Long.valueOf(id_Educacion);
        System.out.println("long idddddd" + longId);
        Educacion educacionOriginal = educacionservice.fetchEducacionById(longId);
        Imagen im = imagenService.findByImagebyimagenId( educacionOriginal.getIdimagen());
        String ImageId_Borrar = im.getImagenId();

        BufferedImage bi = ImageIO.read(educacionimagen.getDocument().getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
         }

         Map result = cloudinaryService.upload(educacionimagen.getDocument());
         im.setName((String)result.get("original_filename"));
         im.setImageUrl( (String)result.get("url"));
         im.setImagenId((String)result.get("public_id"));

         educacionOriginal.setIdimagen((String)result.get("public_id"));
         educacionOriginal.setImagenurl((String)result.get("url"));
         educacionOriginal.setTitulonombre(educacionimagen.getTitulonombre());
         educacionOriginal.setNombreInstitucion(educacionimagen.getNombreInstitucion());
         educacionOriginal.setPeriodo(educacionimagen.getPeriodo());
         educacionOriginal.setInstitucion_url(educacionimagen.getInstitucion_url());
         educacionOriginal.setContenido(educacionimagen.getContenido());


         cloudinaryService.delete(ImageId_Borrar);

         imagenService.save(im);

         educacionservice.updateEducacion(educacionOriginal.getEducacionId(), educacionOriginal);





        // return trabajoservice.updateTrabajo(trabajoId , trabajo);
        return new ResponseEntity(new Mensaje("imagen actualizada correctamente"), HttpStatus.OK);

    }

    @PutMapping("/educacion/acciones/actualizar/sincambios/{id}")
    public Educacion updateUsuario( @PathVariable("id") Long educacionId, @RequestBody Educacion educacion) {

        return educacionservice.updateEducacion(educacionId , educacion);


    }

    
    
}
