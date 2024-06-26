package com.example.springfantasy.repositories;

import com.example.springfantasy.entities.Character;
import com.example.springfantasy.entities.enums.ClasseEnum;
import com.example.springfantasy.entities.enums.RaceEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {

    List<Character> findByNome(String nome);
    List<Character> findByRaceEnum(RaceEnum raceEnum);
    List<Character> findByClasseEnum(ClasseEnum classeEnum);
}
