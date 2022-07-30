package com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository;

import org.springframework.stereotype.Repository;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Curso;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
