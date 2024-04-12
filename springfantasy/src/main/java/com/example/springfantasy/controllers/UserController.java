package com.example.springfantasy.controllers;

import com.example.springfantasy.entities.Character;
import com.example.springfantasy.entities.User;
import com.example.springfantasy.entities.enums.ClasseEnum;
import com.example.springfantasy.entities.enums.GenderEnum;
import com.example.springfantasy.entities.enums.RaceEnum;
import com.example.springfantasy.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.createUser(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUsers =   userService.getAllUser();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        Optional<User> userOptional = userService.getUser(id);
        return ResponseEntity.ok().body(userOptional);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user,@PathVariable Long id){
        Optional<User> userOptional = userService.updateUser(id,user);
        if(userOptional.isPresent()){
            return  ResponseEntity.ok().body(userOptional.get());
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<User>> deleteUserById(@PathVariable Long id){
        Optional<User> userDaCancellare = userService.deleteUserById(id);
        if(userDaCancellare.isPresent()){
            return ResponseEntity.ok().body(userDaCancellare);
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}/disattiva")
    public ResponseEntity<Optional<User>> disableUser(@PathVariable Long id) {
        Optional<User> userDaDisabilitare = userService.disableUser(id);
        if(userDaDisabilitare.isPresent()){
            return ResponseEntity.ok().body(userDaDisabilitare);
        }
        return ResponseEntity.notFound().build();

    }

    @PutMapping("/{id}/attiva")
    public ResponseEntity<Optional<User>> enableUser(@PathVariable Long id) {
        Optional<User> userDaAbilitare = userService.enableUser(id);
        if( userDaAbilitare.isPresent()){
            return ResponseEntity.ok().body( userDaAbilitare);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/search-by-name")
    public ResponseEntity<List<User>> getUserByName(@RequestParam String nome){
        List<User> userOPT = userService.searchByName(nome);
        return ResponseEntity.ok().body(userOPT);
    }

    @GetMapping("/search-by-country")
    public ResponseEntity<List<User>> getUserByCountry(@RequestParam String country){
        List<User> userOPT = userService.searchByCountry(country);
        return ResponseEntity.ok().body(userOPT);
    }

    @GetMapping("/search-by-gender")
    public ResponseEntity<List<User>> getUserByGender(@RequestParam GenderEnum genderEnum){
        List<User> userOPT = userService.searchByGender(genderEnum);
        return ResponseEntity.ok().body(userOPT);
    }
}
