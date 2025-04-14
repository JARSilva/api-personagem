package br.com.rpg.personagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpg.personagem.model.PersonagemSkill;
import br.com.rpg.personagem.model.PersonagemSkillId;

public interface PersonagemSkillRepositoy extends JpaRepository<PersonagemSkill, PersonagemSkillId> {
		
	
	}
