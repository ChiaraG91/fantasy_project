package com.example.springfantasy.services;

import com.example.springfantasy.entities.Character;
import com.example.springfantasy.entities.enums.ClasseEnum;
import com.example.springfantasy.entities.enums.RaceEnum;
import com.example.springfantasy.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService implements CharacterServiceInterface{

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public Character createCharacter(Character character) {
        Character savedCharacter = characterRepository.save(character);
        return savedCharacter;
    }
    @Override
    public List<Character> getAllCharacters() {
        List<Character> characters = characterRepository.findAll();
        return characters;
    }

    @Override
    public Optional<Character> getCharacterById(Long id) {
        Optional<Character> characterOPT = characterRepository.findById(id);
        return characterOPT;
    }

    @Override
    public Optional<Character> updateCharacter(Long id, Character character) {
        Optional<Character> updatedCharacter = characterRepository.findById(id);
        if (updatedCharacter.isPresent()){
            updatedCharacter.get().setNome(character.getNome());
            updatedCharacter.get().setRaceEnum(character.getRaceEnum());
            updatedCharacter.get().setLivelloEnum(character.getLivelloEnum());
            updatedCharacter.get().setClasseEnum(character.getClasseEnum());
            updatedCharacter.get().setDescrizione(character.getDescrizione());
            characterRepository.save(updatedCharacter.get());
        } else {
            return Optional.empty();
        }
        return updatedCharacter;
    }

    @Override
    public Optional<Character> deleteCharacter(Long id) {
        Optional<Character> deletedCharacterOPT = characterRepository.findById(id);
        if(deletedCharacterOPT.isPresent()){
            characterRepository.delete(deletedCharacterOPT.get());
            return deletedCharacterOPT;
        }else{
            return Optional.empty();
        }
    }

    @Override
    public List<Character> searchByName(String nome) {
        List<Character> byName = characterRepository.findByNome(nome);
        return byName;
    }

    @Override
    public List<Character> searchByRace(RaceEnum raceEnum) {
        List<Character> byRace = characterRepository.findByRaceEnum(raceEnum);
        return byRace;
    }

    @Override
    public List<Character> searchByClass(ClasseEnum classeEnum) {
        List<Character> byClass = characterRepository.findByClasseEnum(classeEnum);
        return byClass;
    }
}
