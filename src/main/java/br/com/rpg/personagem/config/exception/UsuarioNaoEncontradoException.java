package br.com.rpg.personagem.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED) // Ou HttpStatus.NOT_FOUND dependendo do caso
public class UsuarioNaoEncontradoException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioNaoEncontradoException() {
        super("Usuário não encontrado");
    }
}