package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute;

import org.springframework.web.multipart.MultipartFile;

public class UsuarioImagenEdit {
    private String userId;
    private String sobremi;
    private String titulo;
    private String subtitulo;
    private String idimagen;
    private String imagenurl;
    private MultipartFile document;


    public String getUserId() {
        return this.userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public MultipartFile getDocument() {
        return this.document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }

   
    
}
