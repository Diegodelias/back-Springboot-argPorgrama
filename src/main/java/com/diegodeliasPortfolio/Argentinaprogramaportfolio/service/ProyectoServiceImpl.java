package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;
import java.util.Objects;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Proyecto;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.ProyectoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectoServiceImpl implements ProyectoService{

    @Autowired
    private ProyectoRepository proyectoRepository ;

    @Override
    public Proyecto saveProyecto(Proyecto proyecto) {
      
      return  proyectoRepository.save(proyecto);
    }

    @Override
    public List<Proyecto> fetchProyectoList() {
      
      return proyectoRepository.findAll();
    }

    @Override
    public Proyecto fetchProyectoById(Long proyectoId) {
      
      return proyectoRepository.findById(proyectoId).get();
    }

    @Override
    public void deleteProyectoByid(Long proyectoId) {
      proyectoRepository.deleteById(proyectoId);
    }

    @Override
    public Proyecto updateProyecto(Long proyectoId, Proyecto proyecto) {

           
        Proyecto proyDb = proyectoRepository.findById(proyectoId).get();

        if(Objects.nonNull(proyecto.getNombreproyecto()) && !"".equalsIgnoreCase(proyecto.getNombreproyecto())) {

            proyDb.setNombreproyecto(proyecto.getNombreproyecto());
         } 
      

         if(Objects.nonNull(proyecto.getDemourl()) && !"".equalsIgnoreCase(proyecto.getDemourl())) {

          proyDb.setDemourl(proyecto.getDemourl());
       } 

       if(Objects.nonNull(proyecto.getGithuburl()) && !"".equalsIgnoreCase(proyecto.getGithuburl())) {

        proyDb.setGithuburl(proyecto.getGithuburl());
      } 


      if(Objects.nonNull(proyecto.getDescripcion()) && !"".equalsIgnoreCase(proyecto.getDescripcion())) {

        proyDb.setDescripcion(proyecto.getDescripcion());
      }
      


      if(Objects.nonNull(proyecto.getFoto_proyecto()) && !"".equalsIgnoreCase(proyecto.getFoto_proyecto())) {

        proyDb.setFoto_proyecto(proyecto.getFoto_proyecto());
      } 


      

      if(Objects.nonNull(proyecto.isTabla_activa())) {

        proyDb.setTabla_activa(proyecto.isTabla_activa());
      } 



      
         return   proyectoRepository.save(proyDb);

    }

    
}
