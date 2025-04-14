package br.com.rpg.personagem.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rpg.personagem.dto.AdicionaSkillDto;
import br.com.rpg.personagem.dto.ListaPersonagemDto;
import br.com.rpg.personagem.dto.LoginDto;
import br.com.rpg.personagem.dto.PersonagemDto;
import br.com.rpg.personagem.service.PersonagemService;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemService service;

    @GetMapping
    public Page<PersonagemDto> listar(@PageableDefault(size = 10) Pageable paginacao) {
        return service.obterTodos(paginacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonagemDto> detalhar(@PathVariable @NotNull Long id) {
        PersonagemDto dto = service.obterPorId(id);
        
        return ResponseEntity.ok(dto);
    }
    
    @GetMapping("/porNome/{nome}")
    public ResponseEntity<PersonagemDto> obterPorNome(@PathVariable @NotNull String nome) {
        PersonagemDto dto = service.obterPorNome(nome);
        
        return ResponseEntity.ok(dto);
    }
    
    @PostMapping("/lista")
    public ResponseEntity<ListaPersonagemDto> listarPorDono(@RequestBody @Valid LoginDto dto) {
    	ListaPersonagemDto lista = service.listarPorDono(dto.getUsername());

        return ResponseEntity.ok(lista);
    }

    @PostMapping
    public ResponseEntity<PersonagemDto> cadastrar(@RequestBody @Valid PersonagemDto dto) {
        PersonagemDto personagem = service.criarPersonagem(dto);

        return ResponseEntity.ok(personagem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonagemDto> atualizar(@PathVariable @NotNull Long id, @RequestBody @Valid PersonagemDto dto) {
        PersonagemDto atualizado = service.atualizarPersonagem(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PersonagemDto> remover(@PathVariable @NotNull Long id) {
        service.excluirPersonagem(id);
        return ResponseEntity.noContent().build();
    }
    
    @PostMapping("adicionaSkill")
    public void adicionaSkill(@RequestBody @Valid AdicionaSkillDto dto) {
        service.adicionarSkill(dto);
    }
}
