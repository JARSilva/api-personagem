package br.com.rpg.personagem.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdicionaSkillDto {
	private String playerName;
    private String characterName;
    private String skillName;
    private Integer level;
}
