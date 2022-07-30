package com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity;

import lombok.Data;
import lombok.NoArgsConstructor;



import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;

import javax.persistence.Table;

import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name ="tbl_curso")

@PrimaryKeyJoinColumn(name = "cursoId")
public class Curso extends Educacion{
    
    private String nombre_curso;

}
