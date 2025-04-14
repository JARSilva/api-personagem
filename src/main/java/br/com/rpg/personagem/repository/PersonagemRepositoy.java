package br.com.rpg.personagem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.rpg.personagem.model.Personagem;

public interface PersonagemRepositoy extends JpaRepository<Personagem, Long> {
	
	Optional<List<Personagem>> findByPlayerName(String name);

	Optional<Personagem> findByCharacterName(String name);
	
	@Modifying
    @Query(value = "INSERT INTO personagem_skill (personagem_id, skill_name, nivel) VALUES (:codigoPersonagem, :codigoSkill, :level)", nativeQuery = true)
    void addSkill(@Param("codigoPersonagem") Long codigoPersonagem, @Param("codigoSkill") String codigoSkill, @Param("level") Integer level);
}
