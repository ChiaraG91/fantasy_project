package com.example.springfantasy.controllers;

import com.example.springfantasy.entities.Character;
import com.example.springfantasy.entities.enums.ClasseEnum;
import com.example.springfantasy.entities.enums.RazzaEnum;
import com.example.springfantasy.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/game")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @PostMapping("/characters")
    public ResponseEntity<Character> addUser(@RequestBody Character character){
       characterService.createCharacter(character);
        return ResponseEntity.ok().body(character);
    }

    @GetMapping("/characters")
    public ResponseEntity<List<Character>> getAllCharacters(){
        List<Character> allCharacters = characterService.getAllCharacters();
        return ResponseEntity.ok().body(allCharacters);
    }

    @GetMapping("/characters/{id}")
    public ResponseEntity<Optional<Character>> getCharacter(@PathVariable Long id){
        Optional<Character> characterOPT = characterService.getCharacterById(id);
        return ResponseEntity.ok().body(characterOPT);
    }

    @PutMapping("/characters/{id}")
    public ResponseEntity<Character> updateCharacterById(@RequestBody Character character,@PathVariable Long id){
        Optional<Character> characterOPT = characterService.updateCharacter(id,character);
        if(characterOPT.isPresent()){
            return  ResponseEntity.ok().body(characterOPT.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/characters/{id}")
    public ResponseEntity<Optional<Character>> deleteCharacterById(@PathVariable Long id){
        Optional<Character> characterOPT = characterService.deleteCharacter(id);
        if(characterOPT.isPresent()){
            return ResponseEntity.ok().body(characterOPT);
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/characters/search-by-name")
    public ResponseEntity<List<Character>> getCharacterByName(@RequestParam String nome){
        List<Character> characterOPT = characterService.searchByName(nome);
        return ResponseEntity.ok().body(characterOPT);
    }
    @GetMapping("/characters/search-by-race")
    public ResponseEntity<List<Character>> getCharacterByRace(@RequestParam RazzaEnum razzaEnum){
        List<Character> characterOPT = characterService.searchByRazza(razzaEnum);
        return ResponseEntity.ok().body(characterOPT);
    }
    @GetMapping("/characters/search-by-class")
    public ResponseEntity<List<Character>> getCharacterByClass(@RequestParam ClasseEnum classeEnum){
        List<Character> characterOPT = characterService.searchByClasse(classeEnum);
        return ResponseEntity.ok().body(characterOPT);
    }
}
