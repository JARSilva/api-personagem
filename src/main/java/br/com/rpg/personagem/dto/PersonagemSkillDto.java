package br.com.rpg.personagem.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonagemSkillDto {
	
	@JsonIgnore
    private PersonagemSkillIdDto id;
    
	@JsonIgnore
    private PersonagemDto personagem;
	
    private SkillDto skill;

    private Integer nivel;
}