package com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "imagen")
public class Imagen {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String imageUrl;
    private String imagenId;


 

    public Imagen() {
    }



  


 

    public Imagen( String name, String imageUrl, String imagenId) {
    
        this.name = name;
        this.imageUrl = imageUrl;
        this.imagenId = imagenId;
    }



    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImagenId() {
        return this.imagenId;
    }

    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
    }




}
