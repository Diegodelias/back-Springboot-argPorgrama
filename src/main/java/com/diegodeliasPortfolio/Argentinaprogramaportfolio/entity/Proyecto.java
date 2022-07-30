package com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="tbl_proyecto")

public class Proyecto {
    @Id
    @SequenceGenerator(
        name = "proyecto_sequence",
        sequenceName ="proyecto_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator ="proyecto_sequence"
    )

    private Long proyectoId;
    private String nombreproyecto;
    private String demourl;
    private String githuburl;
    private String descripcion;
    private String linkvideo;
    private String foto_proyecto;
    private boolean tabla_activa;
    private String imagenurl;
    private String idimagen;

    public Long getProyectoId() {
        return this.proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
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

    public String getLinkvideo() {
        return this.linkvideo;
    }

    public void setLinkvideo(String linkvideo) {
        this.linkvideo = linkvideo;
    }

    public String getFoto_proyecto() {
        return this.foto_proyecto;
    }

    public void setFoto_proyecto(String foto_proyecto) {
        this.foto_proyecto = foto_proyecto;
    }

    public boolean isTabla_activa() {
        return this.tabla_activa;
    }

    public boolean getTabla_activa() {
        return this.tabla_activa;
    }

    public void setTabla_activa(boolean tabla_activa) {
        this.tabla_activa = tabla_activa;
    }

    public String getImagenurl() {
        return this.imagenurl;
    }

    public void setImagenurl(String imagenurl) {
        this.imagenurl = imagenurl;
    }

    public String getIdimagen() {
        return this.idimagen;
    }

    public void setIdimagen(String idimagen) {
        this.idimagen = idimagen;
    }
  
     
}
