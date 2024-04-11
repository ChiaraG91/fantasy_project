package com.example.springfantasy.services;

import com.example.springfantasy.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService implements CharacterServiceInterface{

    @Autowired
    private CharacterRepository characterRepository;



}
