package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Proyecto;

public interface ProyectoService {

    Proyecto saveProyecto(Proyecto proyecto);

    List<Proyecto> fetchProyectoList();

    Proyecto fetchProyectoById(Long proyectoId);

    void deleteProyectoByid(Long proyectoId);

    Proyecto updateProyecto(Long proyectoId, Proyecto proyecto);

   
    
}
