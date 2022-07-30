package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;

import java.io.IOException;
import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute.ProyectoImagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.dto.Mensaje;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Proyecto;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.CloudinaryService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.ImagenService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.ProyectoService;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.http.HttpStatus;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.imageio.ImageIO;


@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ProyectoController {
    @Autowired
    private ProyectoService proyectoservice;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    @RequestMapping(path = "/proyectos", method = RequestMethod.POST,
    consumes = {"multipart/form-data"})

    public ResponseEntity<?>  saveProyecto(@ModelAttribute ProyectoImagen proyectoimagen)throws IOException{
        BufferedImage bi = ImageIO.read(proyectoimagen.getDocument().getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
         }

         Map result = cloudinaryService.upload(proyectoimagen.getDocument());
         Imagen imagen =
         new Imagen((String)result.get("original_filename"),
                 (String)result.get("url"),
                 (String)result.get("public_id"));

         Proyecto proyecto = new Proyecto();
         proyecto.setNombreproyecto(proyectoimagen.getNombreproyecto());
         proyecto.setDemourl(proyectoimagen.getDemourl());
         proyecto.setGithuburl(proyectoimagen.getGithuburl());
         proyecto.setDescripcion(proyectoimagen.getDescripcion());
         proyecto.setLinkvideo(proyectoimagen.getLinkvideo());
         proyecto.setIdimagen((String)result.get("public_id"));
         proyecto.setImagenurl((String)result.get("url"));


         proyectoservice.saveProyecto(proyecto);

         imagenService.save(imagen);


        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
    }


    @GetMapping("/proyectos")
    public List<Proyecto> fetchTrabajoList() {

        return proyectoservice.fetchProyectoList();

        
    }


    @GetMapping("/proyectos/{id}")
    public Proyecto fetchProyectoById(@PathVariable("id") Long proyectoId){

        return proyectoservice.fetchProyectoById(proyectoId);
    }


    
    @DeleteMapping("/proyectos/acciones/borrar/{id}")
    public void deleteProyectosByid(@PathVariable("id") Long proyectoId) {

        proyectoservice.deleteProyectoByid(proyectoId);
        // return "Registro proyecto  borrado correctamente";

    }

    @RequestMapping(path = "/proyectos/acciones/update/{id}", method = RequestMethod.PUT,
    consumes = {"multipart/form-data"})

    public ResponseEntity<?>   updateEducacion(@ModelAttribute ProyectoImagen proyectoimagen) throws IOException  {
        Integer id_Educacion = Integer.parseInt(proyectoimagen.getProyectoId());
        Long longId = Long.valueOf(id_Educacion);

        Proyecto proyectoOriginal = proyectoservice.fetchProyectoById(longId);
        Imagen im = imagenService.findByImagebyimagenId( proyectoOriginal.getIdimagen());
        String ImageId_Borrar = im.getImagenId();
        BufferedImage bi = ImageIO.read(proyectoimagen.getDocument().getInputStream());
       
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
         }
         Map result = cloudinaryService.upload(proyectoimagen.getDocument());

         im.setName((String)result.get("original_filename"));
         im.setImageUrl( (String)result.get("url"));
         im.setImagenId((String)result.get("public_id"));

         proyectoOriginal.setIdimagen((String)result.get("public_id"));
         proyectoOriginal.setImagenurl((String)result.get("url"));
         proyectoOriginal.setNombreproyecto(proyectoimagen.getNombreproyecto());
         proyectoOriginal.setDemourl(proyectoimagen.getDemourl());
         proyectoOriginal.setGithuburl(proyectoimagen.getGithuburl());
         proyectoOriginal.setDescripcion(proyectoimagen.getDescripcion());
         proyectoOriginal.setLinkvideo(proyectoimagen.getLinkvideo());


         
         cloudinaryService.delete(ImageId_Borrar);

         imagenService.save(im);

         proyectoservice.updateProyecto(proyectoOriginal.getProyectoId(), proyectoOriginal);
         







        
        
        
        // return proyectoservice.updateProyecto(proyectoId , proyecto);
        return new ResponseEntity(new Mensaje("imagen actualizada correctamente"), HttpStatus.OK);

    }

    @PutMapping("/proyectos/acciones/update/sincambios/{id}")
    public Proyecto updateProyecto( @PathVariable("id") Long proyectoId, @RequestBody Proyecto proyecto) {

        return proyectoservice.updateProyecto(proyectoId , proyecto);


    }

    
}
