package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute;

import org.springframework.web.multipart.MultipartFile;

public class EducacionImagen {
    private String educacionId;
    private String titulonombre;
    private String nombreInstitucion ;
    private String periodo;
    private String institucion_url;
    private String contenido;
    private MultipartFile document;

    public String getEducacionId() {
        return this.educacionId;


    }

    public MultipartFile getDocument() {
        return this.document;
    }

    public void setDocument(MultipartFile document) {
        this.document = document;
    }

    public void setEducacionId(String educacionId) {
        this.educacionId = educacionId;
    }

    public String getTitulonombre() {
        return this.titulonombre;
    }

    public void setTitulonombre(String titulonombre) {
        this.titulonombre = titulonombre;
    }

    public String getNombreInstitucion() {
        return this.nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getInstitucion_url() {
        return this.institucion_url;
    }

    public void setInstitucion_url(String institucion_url) {
        this.institucion_url = institucion_url;
    }

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    
}
