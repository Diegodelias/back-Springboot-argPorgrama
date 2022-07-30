package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;
import java.util.Objects;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Trabajo;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.TrabajoRespository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TrabajoServiceImpl implements TrabajoService {
    @Autowired
    private TrabajoRespository trabajoRepository ;

    @Override
    public Trabajo saveTrabajo(Trabajo trabajo) {
     
        return  trabajoRepository.save(trabajo);
    }

    @Override
    public List<Trabajo> fetchTrabajoList() {
        
        return  trabajoRepository.findAll();

    }

    @Override
    public Trabajo fetchTrabajoById(Long trabajoId) {
        
        return trabajoRepository.findById(trabajoId).get();
    }

    @Override
    public void deleteTrabajoByid(Long trabajoId) {
    

        trabajoRepository.deleteById(trabajoId);
        
    }

    @Override
    public Trabajo updateTrabajo(Long trabajoId, Trabajo trabajo) {
        
        Trabajo trabDb = trabajoRepository.findById(trabajoId).get();

        if(Objects.nonNull(trabajo.getPuesto()) && !"".equalsIgnoreCase(trabajo.getPuesto())) {

            trabDb.setPuesto(trabajo.getPuesto());
        }

        
        if(Objects.nonNull(trabajo.getDescripcion()) && !"".equalsIgnoreCase(trabajo.getDescripcion())) {

            trabDb.setDescripcion(trabajo.getDescripcion());
        }

           
        if(Objects.nonNull(trabajo.getPeriodo())) {

            
            trabDb.setPeriodo(trabajo.getPeriodo());

          
        }


             
     


        
       


        if(Objects.nonNull(trabajo.getLogo_empresa()) && !"".equalsIgnoreCase(trabajo.getLogo_empresa())) {

            trabDb.setLogo_empresa(trabajo.getLogo_empresa());
        }


        if(Objects.nonNull(trabajo.getEmpresa_nombre()) && !"".equalsIgnoreCase(trabajo.getEmpresa_nombre())) {

            trabDb.setEmpresa_nombre(trabajo.getEmpresa_nombre());
        }


     


           
        if(Objects.nonNull(trabajo.isTrabajo_actual())) {

            trabDb.setTrabajo_actual(trabajo.isTrabajo_actual());
        }


        return   trabajoRepository.save(trabDb);





    }
    
}
