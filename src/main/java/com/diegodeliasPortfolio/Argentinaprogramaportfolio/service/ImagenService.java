package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Imagen;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.ImagenRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenService {

    @Autowired
    ImagenRepository imagenRepository;

    public List<Imagen> list() {

        return imagenRepository.findByOrderById();


    }

    public Optional<Imagen> getOne(int id){

        return imagenRepository.findById(id);

    }

    public void save(Imagen imagen) {
        imagenRepository.save(imagen);
    }
    
    public void delete(int id){
        imagenRepository.deleteById(id);
    }

    
    public Imagen fetchImagenById(int imagenId) {

        return imagenRepository.findById(imagenId).get();
    }



    public Imagen findByImagebyimagenId(String imagenid) {

        return imagenRepository.findByImagebyimagenId(imagenid);
    }


    public boolean exists(int id) {
        return imagenRepository.existsById(id);
    }
}
