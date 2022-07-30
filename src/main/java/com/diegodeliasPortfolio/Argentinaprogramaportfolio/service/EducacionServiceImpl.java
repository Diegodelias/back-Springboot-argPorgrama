package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;
import java.util.Objects;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Educacion;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.EducacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionServiceImpl implements EducacionService{

    @Autowired 
    private EducacionRepository educacionRepository;

    @Override
    public Educacion saveEducacion(Educacion educacion) {
        
        return  educacionRepository.save(educacion);
    }

    @Override
    public List<Educacion> fetchEducacionList() {
        
        return educacionRepository.findAll();
    }

    @Override
    public Educacion fetchEducacionById(Long educacionId) {
        
        return educacionRepository.findById(educacionId).get();
    }

    @Override
    public void deleteUsuarioByid(Long educacionId) {
        
        educacionRepository.deleteById(educacionId);
        
    }

    @Override
    public Educacion updateEducacion(Long educacionId, Educacion educacion) {
        
    Educacion eduDb = educacionRepository.findById(educacionId).get();

        if(Objects.nonNull(educacion.getTitulonombre()) && !"".equalsIgnoreCase(educacion.getTitulonombre())) {

             eduDb.setTitulonombre(educacion.getTitulonombre());
        }


        if(Objects.nonNull(educacion.getNombreInstitucion()) && !"".equalsIgnoreCase(educacion.getNombreInstitucion())) {

            eduDb.setNombreInstitucion(educacion.getNombreInstitucion());
        }

        
        if(Objects.nonNull(educacion.getPeriodo()) && !"".equalsIgnoreCase(educacion.getPeriodo())) {

            eduDb.setPeriodo(educacion.getPeriodo());
        }

         
        if(Objects.nonNull(educacion.getContenido()) && !"".equalsIgnoreCase(educacion.getContenido())) {

            eduDb.setContenido(educacion.getContenido());
        }



     
    
          
        if(Objects.nonNull(educacion.isEn_curso())) {

            eduDb.setEn_curso(educacion.isEn_curso());
        }


        if(Objects.nonNull(educacion.getInstitucion_logo()) && !"".equalsIgnoreCase(educacion.getInstitucion_logo())) {

            eduDb.setInstitucion_logo(educacion.getInstitucion_logo());
        }

     
        

        if(Objects.nonNull(educacion.getInstitucion_url()) && !"".equalsIgnoreCase(educacion.getInstitucion_url())) {

            eduDb.setInstitucion_url(educacion.getInstitucion_url());
        }


           
        if(Objects.nonNull(educacion.isTabla_activa())) {

            eduDb.setTabla_activa(educacion.isTabla_activa());
        }


        return   educacionRepository.save(eduDb);
    }
    
}
