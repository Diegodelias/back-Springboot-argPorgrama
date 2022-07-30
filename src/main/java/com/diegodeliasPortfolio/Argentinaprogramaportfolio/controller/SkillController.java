package com.diegodeliasPortfolio.Argentinaprogramaportfolio.controller;

import java.util.List;

import com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity.Skill;
import com.diegodeliasPortfolio.Argentinaprogramaportfolio.service.SkillService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins="http://localhost:4200")
public class SkillController {
    @Autowired
    private SkillService skillservice;

        
    @PostMapping("/skills")
    public Skill saveSkill(@RequestBody Skill skill){

        return skillservice.saveSkill(skill);
    }


    @GetMapping("/skills")
    public List<Skill> fetchSkillList() {

        return skillservice.fetchSkillList();

    }

    @GetMapping("/skills/{id}")
    public Skill fetchSkillById(@PathVariable("id") Long skillId){

        return skillservice.fetchSkilloById(skillId);
    }


    @DeleteMapping("/skills/acciones/borrar/{id}")
    public void deleteSkillByid(@PathVariable("id") Long skillId) {

        skillservice.deleteSkillByid(skillId);
        // return "Skill  borrada correctamente";

    }


    @PutMapping("/skills/acciones/editar/{id}")
    public Skill updateSkill( @PathVariable("id") Long skillId, @RequestBody Skill skill) {

        return skillservice.updateSkill(skillId , skill);


    }



    
}
