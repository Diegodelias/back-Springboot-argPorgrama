package com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Proyecto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    
}
