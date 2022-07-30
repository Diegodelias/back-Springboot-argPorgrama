package com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;


@Repository
@Transactional(readOnly = true)
public class ImagenRepositoryCustomImpl implements ImagenRepositoryCustom {
    // https://www.bezkoder.com/jpa-entitymanager-spring-boot/
    @PersistenceContext 
    private EntityManager entityManager;
    @Override
    public Imagen findByImagebyimagenId(String imagenid) {

        TypedQuery<Imagen> query = entityManager.createQuery("Select i from Imagen i where i.imagenId = ?1 " ,Imagen.class);
        String imagen_id = imagenid;
        Imagen result = query.setParameter(1,imagen_id).getSingleResult();
       
        return  result;
    }
    
}
