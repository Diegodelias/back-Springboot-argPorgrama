package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute;

import org.springframework.web.multipart.MultipartFile;

public class UsuarioImagen {
   
    private String sobremi;
    private String titulo;
    private String subtitulo;
    private String idimagen;
    private String imagenurl;
    private String headertitulo; 
    private String headersubtitulo;
    private String usuario;
    private String password;
    private String email; 
    private String nombre;
    private String apellido;  
    private MultipartFile document;
   

    public UsuarioImagen() {
    }


    public MultipartFile getDocument() {
        return this.document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }



    public String getHeadertitulo() {
        return this.headertitulo;
    }

    public void setHeadertitulo(String headertitulo) {
        this.headertitulo = headertitulo;
    }

    public String getHeadersubtitulo() {
        return this.headersubtitulo;
    }

    public void setHeadersubtitulo(String headersubtitulo) {
        this.headersubtitulo = headersubtitulo;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    

    public String getSobremi() {
        return this.sobremi;
    }

    public void setSobremi(String sobremi) {
        this.sobremi = sobremi;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return this.subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public String getIdimagen() {
        return this.idimagen;
    }

    public void setIdimagen(String idimagen) {
        this.idimagen = idimagen;
    }

    public String getImagenurl() {
        return this.imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }
    
}
