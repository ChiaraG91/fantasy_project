package com.example.springfantasy.entities;

import com.example.springfantasy.entities.enums.ClasseEnum;
import com.example.springfantasy.entities.enums.LivelloEnum;
import com.example.springfantasy.entities.enums.RazzaEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "character_entity")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Enumerated
    private RazzaEnum razzaEnum;
    @Enumerated
    private ClasseEnum classeEnum;
    @Enumerated
    private LivelloEnum livelloEnum;
    private String descrizione;

    public Character(Long id, String nome, RazzaEnum razzaEnum, ClasseEnum classeEnum, LivelloEnum livelloEnum, String descrizione) {
        this.id = id;
        this.nome = nome;
        this.razzaEnum = razzaEnum;
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

    public RazzaEnum getRazzaEnum() {
        return razzaEnum;
    }

    public void setRazzaEnum(RazzaEnum razzaEnum) {
        this.razzaEnum = razzaEnum;
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
}
