package br.com.rpg.personagem.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonagemSkillIdDto{

	private Long personagemId;
    private String skillName;

}