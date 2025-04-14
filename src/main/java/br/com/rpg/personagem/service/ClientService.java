package br.com.rpg.personagem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rpg.personagem.dto.LoginDto;
import br.com.rpg.personagem.model.Client;
import br.com.rpg.personagem.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	public Client login(LoginDto client) {
		Client clienteEncontrada = this.clientRepository.findByUsername(client.getUsername()).get();
		if(client.getPassword().equals(clienteEncontrada.getPassword()))
			return clienteEncontrada;
		return null;
	}
}
