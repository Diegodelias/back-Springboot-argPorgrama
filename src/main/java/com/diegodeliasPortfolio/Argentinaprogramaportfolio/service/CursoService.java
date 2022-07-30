package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Curso;

public interface CursoService {

    public Curso saveCurso(Curso curso);

    public List<Curso> fetchCursoList();

    public Curso fetchCursoById(Long cursoId);

    public Curso updateCurso(Long cursoId, Curso curso);

    public void deleteCursoByid(Long cursoId);
    
}
