package com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name ="tbl_educacion")
@Inheritance(strategy = InheritanceType.JOINED)
public class Educacion {

    @Id
    @SequenceGenerator(
        name = "educacion_sequence",
        sequenceName ="educacion_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator ="educacion_sequence"
    )
    private Long educacionId;
    private String titulonombre;
    private String nombreInstitucion;
    private String periodo;
    @Lob
    private String contenido;
    private boolean en_curso;
    private String institucion_logo;
    private String institucion_url;
    private boolean tabla_activa;
    private String imagenurl;

    public String getContenido() {
        return this.contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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

    private String idimagen;


    public Long getEducacionId() {
        return this.educacionId;
    }

    public void setEducacionId(Long educacionId) {
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

    public boolean isEn_curso() {
        return this.en_curso;
    }

    public boolean getEn_curso() {
        return this.en_curso;
    }

    public void setEn_curso(boolean en_curso) {
        this.en_curso = en_curso;
    }

    public String getInstitucion_logo() {
        return this.institucion_logo;
    }

    public void setInstitucion_logo(String institucion_logo) {
        this.institucion_logo = institucion_logo;
    }

    public String getInstitucion_url() {
        return this.institucion_url;
    }

    public void setInstitucion_url(String institucion_url) {
        this.institucion_url = institucion_url;
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

    
}
