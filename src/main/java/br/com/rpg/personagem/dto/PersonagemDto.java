package br.com.rpg.personagem.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Lob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonagemDto {
	private Long codigoPersonagem;
	private String playerName;
    private String characterName;
    private Integer level;
    private String startingPath;
    private String ancestry;
    
    private Integer strength;
    private Integer speed;
    private Integer intellect;
    private Integer willpower;
    private Integer awareness;
    private Integer presence;
    
    private Integer physicalDefense;
    private Integer cognitiveDefense;
    private Integer spiritualDefense;
    
    private Integer health;
    private Integer focus;
    private Integer investiture; // For Radiant characters

    private String deflect;
    
    private List<PersonagemSkillDto> skills;
    
    private String talents;
    private String movement;
    private Integer liftingCapacity;
    private String diceRecovery;
    private String senseRange;
    private String injure;
    private String expertise;
    private String weapons;

    private String bag;
    
    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String appearance;
    private String purpose;
    private String obstacle;
    private String goals;
    private String notes;
    private String spheres;
    private String conections;
    private String moreTalents;
    
    private Boolean liberaCabecalho;
    private Boolean liberaStats;
    private Boolean liberaSkills;
    private Boolean liberaInfo;

}
