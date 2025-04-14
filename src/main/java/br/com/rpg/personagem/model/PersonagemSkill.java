package br.com.rpg.personagem.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "personagem_skill")
public class PersonagemSkill {
	
	@JsonIgnore
    @EmbeddedId
    private PersonagemSkillId id;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("personagemId")
    @JoinColumn(name = "personagem_id")
    private Personagem personagem;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("skillName")
    @JoinColumn(name = "skill_name")
    private Skill skill;

    private Integer nivel;
}