package br.com.rpg.personagem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personagem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("codigo_personagem")
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
    
    @OneToMany(mappedBy = "personagem", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<PersonagemSkill> skills;
    
    private String talents;
    private String movement;
    private Integer liftingCapacity;
    private String diceRecovery;
    private String senseRange;
    private String injure;
    private String expertise;
    private String weapons;

    private String bag;
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
