package br.com.rpg.personagem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpg.personagem.config.exception.UsuarioNaoEncontradoException;
import br.com.rpg.personagem.dto.LoginDto;
import br.com.rpg.personagem.model.Client;
import br.com.rpg.personagem.service.ClientService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private ClientService service;
	
	@PostMapping
    public ResponseEntity<Void> login(@RequestBody @Valid LoginDto dto) {
        Client client = service.login(dto);
        
        if (client != null) {
            return ResponseEntity.noContent().build();
        } else {
            throw new UsuarioNaoEncontradoException(); 
        }
    }

}
