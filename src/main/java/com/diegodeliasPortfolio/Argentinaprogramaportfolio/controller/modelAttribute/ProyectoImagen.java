package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute;

import org.springframework.web.multipart.MultipartFile;

public class ProyectoImagen {
    private String proyectoId;
    private String nombreproyecto;
    private String demourl;
    private String githuburl;
    private String descripcion;
    private String  linkvideo;
    private MultipartFile document;

    public String getLinkvideo() {
        return this.linkvideo;
    }

    public String getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(String proyectoId) {
        this.proyectoId = proyectoId;
    }

    public void setLinkvideo(String linkvideo) {
        this.linkvideo = linkvideo;
    }


    public String getNombreproyecto() {
        return this.nombreproyecto;
    }

    public void setNombreproyecto(String nombreproyecto) {
        this.nombreproyecto = nombreproyecto;
    }


    public String getDemourl() {
        return this.demourl;
    }

    public void setDemourl(String demourl) {
        this.demourl = demourl;
    }

    public String getGithuburl() {
        return this.githuburl;
    }

    public void setGithuburl(String githuburl) {
        this.githuburl = githuburl;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public MultipartFile getDocument() {
        return this.document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }

}
