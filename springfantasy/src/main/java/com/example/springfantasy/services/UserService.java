package com.example.springfantasy.services;

import com.example.springfantasy.entities.User;
import com.example.springfantasy.entities.enums.GenderEnum;
import com.example.springfantasy.entities.enums.StatusEnum;
import com.example.springfantasy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<User> getAllUser() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public Optional<User> getUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional;
    }

    public Optional<User> updateUser(Long id, User user) {
        Optional<User> userDaAggiornare = userRepository.findById(id);
        if (userDaAggiornare.isPresent()) {
            userDaAggiornare.get().setNome(user.getNome());
            userDaAggiornare.get().setEmail(user.getEmail());
            userDaAggiornare.get().setCountry(user.getCountry());
            userRepository.save(userDaAggiornare.get());
        } else {
            return Optional.empty();
        }
        return userDaAggiornare;
    }


    public Optional<User> deleteUserById(Long id) {
        Optional<User> userDaCancellareOptional = userRepository.findById(id);
        if (userDaCancellareOptional.isPresent()) {
            userRepository.delete(userDaCancellareOptional.get());
            return userDaCancellareOptional;
        } else {
            return Optional.empty();
        }

    }

    public Optional<User> disableUser(Long id){
        Optional<User> userOPT = userRepository.findById(id);
        if (userOPT.isPresent()) {
            userOPT.get().setStatusEnum(StatusEnum.INACTIVE);
            User user = userRepository.save(userOPT.get());
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public Optional<User> enableUser(Long id){
        Optional<User> userOPT = userRepository.findById(id);
        if (userOPT.isPresent()) {
            userOPT.get().setStatusEnum(StatusEnum.ACTIVE);
            User user = userRepository.save(userOPT.get());
            return Optional.of(user);
        }
        return Optional.empty();
    }

    public List<User> searchByName(String nome) {
        List<User> byName = userRepository.findByNome(nome);
        return byName;
    }

    public List<User> searchByCountry(String country) {
        List<User> byCountry = userRepository.findByCountry(country);
        return byCountry;
    }

    public List<User> searchByGender(GenderEnum genderEnum) {
        List<User> byGender = userRepository.findByGenderEnum(genderEnum);
        return byGender;
    }
}