package br.com.rpg.personagem.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.rpg.personagem.dto.AdicionaSkillDto;
import br.com.rpg.personagem.dto.ListaPersonagemDto;
import br.com.rpg.personagem.dto.PersonagemDto;
import br.com.rpg.personagem.dto.PersonagemItemDto;
import br.com.rpg.personagem.model.Personagem;
import br.com.rpg.personagem.model.PersonagemSkill;
import br.com.rpg.personagem.model.PersonagemSkillId;
import br.com.rpg.personagem.model.Skill;
import br.com.rpg.personagem.repository.PersonagemRepositoy;
import br.com.rpg.personagem.repository.PersonagemSkillRepositoy;
import br.com.rpg.personagem.repository.SkillRepositoy;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepositoy repository;
    
    @Autowired
    private PersonagemSkillRepositoy personagemSkillRepository;
    
    @Autowired
    private SkillRepositoy skillRepository;

    @Autowired
    private ModelMapper modelMapper;


    public Page<PersonagemDto> obterTodos(Pageable paginacao) {
        return repository
                .findAll(paginacao)
                .map(p -> modelMapper.map(p, PersonagemDto.class));
    }

    public PersonagemDto obterPorId(Long id) {
    	Personagem personagem = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(personagem, PersonagemDto.class);
    }
    
    public PersonagemDto obterPorNome(String name) {
    	Personagem personagem = repository.findByCharacterName(name)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(personagem, PersonagemDto.class);
    }

    public PersonagemDto criarPersonagem(PersonagemDto dto) {
    	Personagem personagem = modelMapper.map(dto, Personagem.class);
        repository.save(personagem);

        return modelMapper.map(personagem, PersonagemDto.class);
    }

    public PersonagemDto atualizarPersonagem(Long id, PersonagemDto dto) {
    	Personagem personagem = modelMapper.map(dto, Personagem.class);
        personagem.setCodigoPersonagem(id);
        personagem = repository.save(personagem);
        return modelMapper.map(personagem, PersonagemDto.class);
    }

    public void excluirPersonagem(Long id) {
        repository.deleteById(id);
    }
    
    @Transactional
	public void adicionarSkill(AdicionaSkillDto dto) {
		Personagem personagem = repository.findByCharacterName(dto.getCharacterName()).get();
		Skill skill = skillRepository.findById(dto.getSkillName()).get();
		PersonagemSkill personagemSkill = new PersonagemSkill(new PersonagemSkillId(personagem.getCodigoPersonagem(),skill.getName()), personagem, skill, dto.getLevel());
		personagemSkillRepository.save(personagemSkill);
	}

	public ListaPersonagemDto listarPorDono(String characterName) {
		List<Personagem> personagens = repository.findByPlayerName(characterName).get();

	    List<PersonagemItemDto> personagemDtos = personagens.stream()
	        .map(p -> new PersonagemItemDto(p.getCodigoPersonagem(),p.getCharacterName(), ""))
	        .collect(Collectors.toList());

	    return new ListaPersonagemDto(personagemDtos);
	}



}

