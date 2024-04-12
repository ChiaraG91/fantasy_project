package com.example.springfantasy.services;

import com.example.springfantasy.entities.Character;
import com.example.springfantasy.entities.enums.ClasseEnum;
import com.example.springfantasy.entities.enums.RaceEnum;

import java.util.List;
import java.util.Optional;

public interface CharacterServiceInterface {

    List<Character> getAllCharacters(); //Restituisce l'elenco completo dei personaggi.
    Optional<Character> getCharacterById(Long id); //Restituisce un personaggio specifico per ID.
    Character createCharacter(Character character); //Crea un nuovo personaggio.
    Optional<Character> updateCharacter(Long id, Character character); //Aggiorna i dettagli di un personaggio esistente.
	Optional<Character> deleteCharacter(Long id); //Rimuove un personaggio dall'elenco.
    List<Character> searchByName(String nome); //Cerca personaggi per nome.
    List<Character> searchByRace(RaceEnum raceEnum); //Cerca personaggi per razza.
    List<Character> searchByClass(ClasseEnum classeEnum); //Cerca personaggi per classe.

}
