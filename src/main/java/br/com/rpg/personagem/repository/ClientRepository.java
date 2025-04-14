package br.com.rpg.personagem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rpg.personagem.model.Client;

public interface ClientRepository extends JpaRepository<Client, String>{
	
	Optional<Client> findByUsername(String name);
}
