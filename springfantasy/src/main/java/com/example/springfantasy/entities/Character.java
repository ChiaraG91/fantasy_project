package com.example.springfantasy.entities;

import com.example.springfantasy.entities.enums.ClasseEnum;
import com.example.springfantasy.entities.enums.LivelloEnum;
import com.example.springfantasy.entities.enums.RaceEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "character_entity")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated
    private RaceEnum raceEnum;
    @Enumerated
    private ClasseEnum classeEnum;
    @Enumerated
    private LivelloEnum livelloEnum;
    private String descrizione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Character(Long id, String nome, RaceEnum raceEnum, ClasseEnum classeEnum, LivelloEnum livelloEnum, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.raceEnum = raceEnum;
        this.classeEnum = classeEnum;
        this.livelloEnum = livelloEnum;
        this.descrizione = descrizione;
    }

    public Character() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public RaceEnum getRaceEnum() {
        return raceEnum;
    }

    public void setRaceEnum(RaceEnum raceEnum) {
        this.raceEnum = raceEnum;
    }

    public ClasseEnum getClasseEnum() {
        return classeEnum;
    }

    public void setClasseEnum(ClasseEnum classeEnum) {
        this.classeEnum = classeEnum;
    }

    public LivelloEnum getLivelloEnum() {
        return livelloEnum;
    }

    public void setLivelloEnum(LivelloEnum livelloEnum) {
        this.livelloEnum = livelloEnum;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
