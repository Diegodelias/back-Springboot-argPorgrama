package com.diegodeliasPortfolio.Argentinaprogramaportfolio.service;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Skill;

public interface SkillService {

   public Skill saveSkill(Skill skill);

public List<Skill> fetchSkillList();

public Skill fetchSkilloById(Long skillId);

public void deleteSkillByid(Long skillId);

public Skill updateSkill(Long skillId, Skill skill);
    
}
