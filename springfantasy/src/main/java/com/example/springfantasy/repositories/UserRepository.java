package com.example.springfantasy.repositories;

import com.example.springfantasy.entities.Character;
import com.example.springfantasy.entities.User;
import com.example.springfantasy.entities.enums.GenderEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findByNome(String nome);
    List<User> findByCountry(String country);
    List<User> findByGenderEnum(GenderEnum genderEnum);

}
