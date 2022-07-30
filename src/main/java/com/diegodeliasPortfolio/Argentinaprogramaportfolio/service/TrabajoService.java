package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Trabajo;

public interface TrabajoService {

    Trabajo saveTrabajo(Trabajo trabajo);

    List<Trabajo> fetchTrabajoList();

    Trabajo fetchTrabajoById(Long trabajoId);

    void deleteTrabajoByid(Long trabajoId);

    Trabajo updateTrabajo(Long trabajoId, Trabajo trabajo);
    
}
