package com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;

import java.util.List;

@Repository
public interface ImagenRepository extends JpaRepository<Imagen , Integer> , ImagenRepositoryCustom{
    List<Imagen> findByOrderById();
    
}
