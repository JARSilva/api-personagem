package br.com.rpg.personagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpg.personagem.model.Skill;

public interface SkillRepositoy extends JpaRepository<Skill, String> {

	
	}
