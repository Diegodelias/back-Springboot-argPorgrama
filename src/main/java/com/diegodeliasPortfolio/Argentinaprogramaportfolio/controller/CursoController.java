package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Curso;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class CursoController {

    
    @Autowired
    private CursoService cursoservice;

      
    @PostMapping("/cursos")
    public Curso saveCurso(@RequestBody Curso curso){

        return cursoservice.saveCurso(curso);
    }


    
    @GetMapping("/cursos")
    public List<Curso> fetchCursoList() {

        return cursoservice.fetchCursoList();

        
    }



    @GetMapping("/cursos/{id}")
    public Curso fetchCursoById(@PathVariable("id") Long cursoId){

        return cursoservice.fetchCursoById(cursoId);
    }


    @DeleteMapping("/cursos/{id}")
    public String deleteCursoByid(@PathVariable("id") Long cursoId) {

        cursoservice.deleteCursoByid(cursoId);
        return "curso  borrado correctamente";

    }

    @PutMapping("/cursos/{id}")
    public Curso updateCurso( @PathVariable("id") Long cursoId, @RequestBody Curso curso) {

        return cursoservice.updateCurso(cursoId , curso);


    }


    
}
