package com.example.simpleusersapi.repository;

import com.example.simpleusersapi.User.UserFieldForm;
import com.example.simpleusersapi.User.UserLogin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserRepository extends MongoRepository<UserFieldForm, String> {

    UserFieldForm findByEmail(String email);


}
