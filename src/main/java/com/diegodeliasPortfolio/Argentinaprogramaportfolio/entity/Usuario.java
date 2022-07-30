package com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;




// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.NoArgsConstructor;
// import lombok.Builder;


@Entity
@Table(name = "Usuarios")
//Generates getters for all fields, a useful toString method, and hashCode and equals implementations that check all non-transient fields.
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder

public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "userid")
    private Long userId;
    private String headertitulo;
    private String headersubtitulo;
    
    
    private String nombre;
    private String apellido;
    private String imagenurl;

    private String idimagen;

    private String usuario;
   
    private String email;

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
    private String password;

 
   

 
  
    @Lob
    private String sobremi;
    private String titulo;
    private String subtitulo;

   

    public Usuario() {
    }


    public Usuario( String usuario,  String password , String email) {
       
   
        this.usuario = usuario;
        this.email = email;
        this.password = password;
    
      
    }

 
    
    @OneToMany(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "userId"
    )
    private List<Educacion> educacion;



    @OneToMany(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "userId"
    )
    private List<Trabajo> trabajo;


    

    @OneToMany(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "userId"
    )
    private List<Proyecto> proyecto;



    
    @OneToMany(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "user_id",
        referencedColumnName = "userId"
    )
    private List<Skill> skills;

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




    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Educacion> getEducacion() {
        return this.educacion;
    }

    public void setEducacion(List<Educacion> educacion) {
        this.educacion = educacion;
    }

    public List<Trabajo> getTrabajo() {
        return this.trabajo;
    }

    public void setTrabajo(List<Trabajo> trabajo) {
        this.trabajo = trabajo;
    }

    public List<Proyecto> getProyecto() {
        return this.proyecto;
    }

    public void setProyecto(List<Proyecto> proyecto) {
        this.proyecto = proyecto;
    }

    public List<Skill> getSkills() {
        return this.skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }


    
}
