package com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Trabajo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRespository  extends JpaRepository<Trabajo, Long>{
    
}
