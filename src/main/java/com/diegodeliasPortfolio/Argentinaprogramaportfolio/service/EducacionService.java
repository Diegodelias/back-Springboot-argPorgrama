package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Educacion;

public interface EducacionService {

   public Educacion saveEducacion(Educacion educacion);

   public List<Educacion> fetchEducacionList();

public Educacion fetchEducacionById(Long educacionId);

public void deleteUsuarioByid(Long educacionId);

public Educacion updateEducacion(Long educacionId, Educacion educacion);
    
}
