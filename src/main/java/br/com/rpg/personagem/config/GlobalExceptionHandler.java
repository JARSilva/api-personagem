package br.com.rpg.personagem.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.rpg.personagem.config.exception.UsuarioNaoEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UsuarioNaoEncontradoException.class)
    public ResponseEntity<Map<String, String>> handleUsuarioNaoEncontrado(UsuarioNaoEncontradoException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Usuário não encontrado");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }
}