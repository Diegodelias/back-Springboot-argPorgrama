package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller.modelAttribute;

import org.springframework.web.multipart.MultipartFile;

public class TrabajoImagen {
    private String trabajoId;
    private String puesto;
    private String empresa_nombre;
    private String periodo;
    private String idimagen;
    private String imagenurl;
    private String descripcion;
    private MultipartFile document;
   

    public String getPuesto() {


        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpresa_nombre() {
        return this.empresa_nombre;
    }

    public String getTrabajoId() {
        return this.trabajoId;
    }

    public void setTrabajoId(String trabajoId) {
        this.trabajoId = trabajoId;
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

    public void setEmpresa_nombre(String empresa_nombre) {
        this.empresa_nombre = empresa_nombre;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
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
