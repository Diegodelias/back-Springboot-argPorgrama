package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;
import java.util.Objects;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Curso;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {
    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public Curso saveCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public List<Curso> fetchCursoList() {

        return cursoRepository.findAll();
    }

    @Override
    public Curso fetchCursoById(Long cursoId) {

        return cursoRepository.findById(cursoId).get();
    }

    @Override
    public Curso updateCurso(Long cursoId, Curso curso) {

        Curso cursoDb = cursoRepository.findById(cursoId).get();

        if (Objects.nonNull(curso.getNombreInstitucion()) && !"".equalsIgnoreCase(curso.getNombreInstitucion())) {

            cursoDb.setNombreInstitucion(curso.getNombreInstitucion());
        }

        if (Objects.nonNull(curso.isEn_curso())) {

            cursoDb.setEn_curso(curso.isEn_curso());
        }

        if (Objects.nonNull(curso.getInstitucion_logo()) && !"".equalsIgnoreCase(curso.getInstitucion_logo())) {

            cursoDb.setInstitucion_logo(curso.getInstitucion_logo());
        }

        if (Objects.nonNull(curso.getInstitucion_url()) && !"".equalsIgnoreCase(curso.getInstitucion_url())) {

            cursoDb.setInstitucion_url(curso.getInstitucion_url());
        }

        if (Objects.nonNull(curso.isTabla_activa())) {

            curso.setTabla_activa(curso.isTabla_activa());
        }

        if (Objects.nonNull(curso.getNombre_curso()) && !"".equalsIgnoreCase(curso.getNombre_curso())) {

            cursoDb.setNombre_curso(curso.getNombre_curso());
        }

        return cursoRepository.save(cursoDb);

    }

    @Override
    public void deleteCursoByid(Long cursoId) {

        cursoRepository.deleteById(cursoId);
    }

}
