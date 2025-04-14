package br.com.rpg.personagem.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class PersonagemSkillId implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1006983578304725325L;
	private Long personagemId;
    private String skillName;

}