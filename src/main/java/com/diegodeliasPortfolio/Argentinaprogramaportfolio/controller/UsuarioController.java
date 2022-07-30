package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute.UsuarioImagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute.UsuarioImagenEdit;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute.UsuarioImagenEditNull;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.dto.Mensaje;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Usuario;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.UsuarioService;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.CloudinaryService;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.ImagenService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UsuarioController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    @Autowired   
    private UsuarioService usuarioService;
  
    // @PostMapping("/usuarios" )
    @RequestMapping(path = "/usuarios", method = RequestMethod.POST,
        consumes = {"multipart/form-data"})
    public ResponseEntity<?>  saveUsuario(@ModelAttribute UsuarioImagen usuarioimagen ) throws IOException  {
        // public ResponseEntity<?> upload (@RequestParam MultipartFile multipartFile)throws IOException {
            BufferedImage bi = ImageIO.read(usuarioimagen.getDocument().getInputStream());
            if(bi == null){
                return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
             }
        Map result = cloudinaryService.upload(usuarioimagen.getDocument());
        Imagen imagen =
                new Imagen((String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"));
        Usuario usuario = new Usuario();
      
        usuario.setSobremi(usuarioimagen.getSobremi());
        usuario.setTitulo(usuarioimagen.getTitulo());
        usuario.setSubtitulo(usuarioimagen.getSubtitulo());
        usuario.setIdimagen(usuarioimagen.getIdimagen());
        usuario.setImagenurl((String)result.get("url"));
        usuario.setIdimagen((String)result.get("public_id"));
        usuario.setHeadertitulo(usuarioimagen.getHeadertitulo());
        usuario.setHeadersubtitulo(usuarioimagen.getHeadersubtitulo());
        usuario.setUsuario(usuarioimagen.getUsuario());
        usuario.setPassword(usuarioimagen.getPassword());
        usuario.setEmail(usuarioimagen.getEmail());
        usuario.setNombre(usuarioimagen.getNombre());
        usuario.setApellido(usuarioimagen.getApellido());




        // usuario.setImagenurl((String)result.get("url"));

        usuarioService.saveUsuario(usuario);
        imagenService.save(imagen);
        return new ResponseEntity(new Mensaje("imagen subida"), HttpStatus.OK);
        // return new ResponseEntity(result, HttpStatus.OK);
            
        // return usuarioService.saveUsuario(usuario);
        
    }



    // @CrossOrigin(origins="http://localhost:4200")
    @GetMapping("/usuarios")
    public List<Usuario> fetchUsuarioList() {
        return usuarioService.fetchUsuarioList();
    }

    @GetMapping("/usuarios/{id}")
    public  Usuario fetchUsuarioById(@PathVariable("id") Long usuarioId){

        return usuarioService.fetchUsuarioById(usuarioId);

    }

    @DeleteMapping("/usuarios/acciones/borrar/{id}")
    public void  deleteUsuarioByid(@PathVariable("id") Long usuarioId) {

        usuarioService.deleteUsuarioByid(usuarioId);
     

    }



    @RequestMapping(path = "/usuarios/acciones/update/{id}", method = RequestMethod.PUT,
    consumes = {"multipart/form-data"})
    // @PutMapping("/usuarios/{id}")
    // public Usuario updateUsuario( @PathVariable("id") Long usuarioId, @RequestBody Usuario usuario) {
    public  ResponseEntity<?>  updateUsuario(@ModelAttribute UsuarioImagenEdit usuarioimagenedit) throws IOException {
        // https://dzone.com/articles/add-custom-functionality-to-a-spring-data-reposito
        
        //traer usuario
        System.out.println("ususario id " + usuarioimagenedit.getUserId());
        Integer id_User = Integer.parseInt(usuarioimagenedit.getUserId());
        Long longId = Long.valueOf(id_User);
        Usuario usuoriginal  =  usuarioService.fetchUsuarioById(longId);
        //image service update method pasar id de la imagen cuyo image id igual a valor image id en el usuario
        Imagen im = imagenService.findByImagebyimagenId(usuoriginal.getIdimagen()); //para obtener image id de la imagen

        String ImageId_Borrar = im.getImagenId();
        //subir imagen nueva a cloudinary

        
        BufferedImage bi = ImageIO.read(usuarioimagenedit.getDocument().getInputStream());
        if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
         }
        Map result = cloudinaryService.upload(usuarioimagenedit.getDocument());
        System.out.println("sobre mi" + usuarioimagenedit.getSobremi());
        im.setName((String)result.get("original_filename"));
        im.setImageUrl( (String)result.get("url"));
        im.setImagenId((String)result.get("public_id"));
        usuoriginal.setIdimagen((String)result.get("public_id"));
        usuoriginal.setImagenurl((String)result.get("url"));
        usuoriginal.setSobremi(usuarioimagenedit.getSobremi());
        usuoriginal.setTitulo(usuarioimagenedit.getTitulo());
        usuoriginal.setSubtitulo(usuarioimagenedit.getSubtitulo());


        cloudinaryService.delete(ImageId_Borrar);
        
        imagenService.save(im);
        usuarioService.updateUsuario(usuoriginal.getUserId() , usuoriginal);


        //asociar urlimagen subida  a cloudiary a imagen traida en el primer paso 


        //actualizar campo idm

        // upload imagen en cloudinary borrar iamgen vieja y asociar url , etc a la imagen traida en el paso anterior
        //salvar imagen con modificaciones
        //update de la url de la imagen en el usuario
        //guardar usuario

        
        // return usuarioService.updateUsuario(usuarioId , usuario);
        return new ResponseEntity(new Mensaje("imagen actualizada correctamente"), HttpStatus.OK);


    }




    // @RequestMapping(path = "/usuarios/sincambios/{id}", method = RequestMethod.PUT,
    // consumes = {"multipart/form-data"})
    // // @PutMapping("/usuarios/{id}")
    // // public Usuario updateUsuario( @PathVariable("id") Long usuarioId, @RequestBody Usuario usuario) {
    // public  ResponseEntity<?>  updateUsuarioNull(@ModelAttribute UsuarioImagenEditNull usuarioimagenedit) throws IOException {
    //     // https://dzone.com/articles/add-custom-functionality-to-a-spring-data-reposito
        
    //     //traer usuario
    //     System.out.println("ususario id " + usuarioimagenedit.getUserId());
    //     Integer id_User = Integer.parseInt(usuarioimagenedit.getUserId());
    //     Long longId = Long.valueOf(id_User);
    //     Usuario usuoriginal  =  usuarioService.fetchUsuarioById(longId);
    //     //image service update method pasar id de la imagen cuyo image id igual a valor image id en el usuario
    //     Imagen im = imagenService.findByImagebyimagenId(usuoriginal.getIdimagen()); //para obtener image id de la imagen

    //     imagenService.save(im);
    //     usuarioService.updateUsuario(usuoriginal.getUserId() , usuoriginal);


    //     //asociar urlimagen subida  a cloudiary a imagen traida en el primer paso 


    //     //actualizar campo idm

    //     // upload imagen en cloudinary borrar iamgen vieja y asociar url , etc a la imagen traida en el paso anterior
    //     //salvar imagen con modificaciones
    //     //update de la url de la imagen en el usuario
    //     //guardar usuario

        
    //     // return usuarioService.updateUsuario(usuarioId , usuario);
    //     return new ResponseEntity(new Mensaje("imagen actualizada correctamente"), HttpStatus.OK);


    // }




    @PutMapping("/usuarios/acciones/update/sincambios/{id}")
    public Usuario updateUsuario( @PathVariable("id") Long usuarioId, @RequestBody Usuario usuario) {

        return usuarioService.updateUsuario(usuarioId , usuario);


    }


}
