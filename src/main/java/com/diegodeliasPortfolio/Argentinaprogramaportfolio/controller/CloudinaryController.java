package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.dto.Mensaje;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;
// import com.tutorial.cloudinaryrest.entity.Imagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.CloudinaryService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.ImagenService;

// import com.tutorial.cloudinaryrest.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/cloudinary")
// @CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="https://portfoliobackdiegodelias.herokuapp.com")
public class CloudinaryController {
    
    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    @GetMapping("/list")
    public ResponseEntity<List<Imagen>> list(){
        List<Imagen> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
            BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
            if(bi == null){
                return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
             }
        Map result = cloudinaryService.upload(multipartFile);
        Imagen imagen =
                new Imagen((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        
        imagenService.save(imagen);
        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
        // return new ResponseEntity(result, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id)throws IOException {
        if(!imagenService.exists(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Imagen imagen = imagenService.getOne(id).get();
        Map result = cloudinaryService.delete(imagen.getImagenId());
        // Map result = cloudinaryService.delete(id);
        imagenService.delete(id);
        // return new ResponseEntity(result, HttpStatus.OK);
        return new ResponseEntity(new Mensaje("imagen eliminada"), HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public  Imagen fetchImagenById(@PathVariable("id") int imagenId){

        return imagenService.fetchImagenById(imagenId);

    }
}
