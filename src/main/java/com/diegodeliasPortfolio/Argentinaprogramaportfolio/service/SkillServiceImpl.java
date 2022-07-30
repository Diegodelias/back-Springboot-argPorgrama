package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;
import java.util.Objects;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Skill;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.repository.SkillRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository ;

    @Override
    public Skill saveSkill(Skill skill) {
        return  skillRepository.save(skill);
    }

    @Override
    public List<Skill> fetchSkillList() {
        
        return  skillRepository.findAll();
    }

    @Override
    public Skill fetchSkilloById(Long skillId) {
        
        return skillRepository.findById(skillId).get();
    }

    @Override
    public void deleteSkillByid(Long skillId) {
        
        skillRepository.deleteById(skillId);
        
    }

    @Override
    public Skill updateSkill(Long skillId, Skill skill) {
        Skill skillDb = skillRepository.findById(skillId).get();

        if(Objects.nonNull(skill.getSkillnombre()) && !"".equalsIgnoreCase(skill.getSkillnombre())) {

            skillDb.setSkillnombre(skill.getSkillnombre());
        }

        
      

        
        
        if(Objects.nonNull(skill.getTipo()) && !"".equalsIgnoreCase(skill.getTipo())) {

            skillDb.setTipo(skill.getTipo());
        }




        
        if(Objects.nonNull(skill.getSkillporcentaje()) && skill.getSkillporcentaje() > 0  && skill.getSkillporcentaje() <= 100 ) {

            skillDb.setSkillporcentaje(skill.getSkillporcentaje());
        }


        if(Objects.nonNull(skill.isTablaactiva())) {

            skillDb.setTablaactiva(skill.isTablaactiva());
        }






           

        return   skillRepository.save(skillDb);
    }
    
}
