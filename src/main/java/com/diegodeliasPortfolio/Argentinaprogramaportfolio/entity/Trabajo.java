package com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity;

// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.Builder;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// import lombok.AllArgsConstructor;

@Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder
@Table(name ="tbl_trabajo")
public class Trabajo {

    @Id
    @SequenceGenerator(
        name = "trabajo_sequence",
        sequenceName ="trabajo_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator ="trabajo_sequence"
    )
    private Long trabajoId;
    private String puesto;
    // @Column(name = "fecha_inicio", columnDefinition = "DATE")
    // private LocalDate inicio; 
    // @Column(name = "fecha_fin", columnDefinition = "DATE") 
    // private LocalDate finalizacion; 
    // private String mesIncio;

    private String periodo;
    
    private String logo_empresa;
    private String empresa_nombre;
    private boolean trabajo_actual ;
    private boolean tabla_activa;   
    private String imagenurl;

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

    @Lob
    private String descripcion;


    public Long getTrabajoId() {
        return this.trabajoId;
    }

    public void setTrabajoId(Long trabajoId) {
        this.trabajoId = trabajoId;
    }

    public String getPuesto() {
        return this.puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

  
    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }


    public String getLogo_empresa() {
        return this.logo_empresa;
    }

    public void setLogo_empresa(String logo_empresa) {
        this.logo_empresa = logo_empresa;
    }

    public String getEmpresa_nombre() {
        return this.empresa_nombre;
    }

    public void setEmpresa_nombre(String empresa_nombre) {
        this.empresa_nombre = empresa_nombre;
    }

    public boolean isTrabajo_actual() {
        return this.trabajo_actual;
    }

    public boolean getTrabajo_actual() {
        return this.trabajo_actual;
    }

    public void setTrabajo_actual(boolean trabajo_actual) {
        this.trabajo_actual = trabajo_actual;
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

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}