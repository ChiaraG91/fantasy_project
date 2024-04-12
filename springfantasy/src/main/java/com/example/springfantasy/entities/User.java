package com.example.springfantasy.entities;

import com.example.springfantasy.entities.enums.GenderEnum;
import com.example.springfantasy.entities.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Column(unique = true)
    private String email;
    @Enumerated
    private GenderEnum genderEnum;
    private String country;
    private StatusEnum statusEnum;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Character> characterList;

    public User(Long id, String nome, String email, GenderEnum genderEnum, String country,StatusEnum statusEnum) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.genderEnum = genderEnum;
        this.country = country;
        this.statusEnum = statusEnum;
    }

    public User() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderEnum getGenderEnum() {
        return genderEnum;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Character> getCharacterList() {
        return characterList;
    }

    public void setCharacterList(List<Character> characterList) {
        this.characterList = characterList;
    }

    public StatusEnum getStatusEnum() {
        return statusEnum;
    }

    public void setStatusEnum(StatusEnum statusEnum) {
        this.statusEnum = statusEnum;
    }
}
