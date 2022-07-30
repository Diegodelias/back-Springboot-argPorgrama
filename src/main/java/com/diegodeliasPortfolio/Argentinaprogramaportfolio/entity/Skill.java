package com.diegodeliasPortfolio.Argentinaprogramaportfolio.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.NoArgsConstructor;



@Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @Builder
@Table(name ="tbl_Skills")
public class Skill {
    
    @Id
    @SequenceGenerator(
        name = "skills_sequence",
        sequenceName ="skills_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator ="skills_sequence"
    )

    private Long skillId;
    private String skillnombre;
    private String skillimagen;
    private Integer skillporcentaje;
    private String tipo;
    private boolean tablaactiva;


    public Long getSkillId() {
        return this.skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }

    public String getSkillnombre() {
        return this.skillnombre;
    }

    public void setSkillnombre(String skillnombre) {
        this.skillnombre = skillnombre;
    }

    public String getSkillimagen() {
        return this.skillimagen;
    }

    public void setSkillimagen(String skillimagen) {
        this.skillimagen = skillimagen;
    }

    public Integer getSkillporcentaje() {
        return this.skillporcentaje;
    }

    public void setSkillporcentaje(Integer skillporcentaje) {
        this.skillporcentaje = skillporcentaje;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isTablaactiva() {
        return this.tablaactiva;
    }

    public boolean getTablaactiva() {
        return this.tablaactiva;
    }

    public void setTablaactiva(boolean tablaactiva) {
        this.tablaactiva = tablaactiva;
    }

}
