package com.example.simpleusersapi.service;

import com.example.simpleusersapi.User.UserFieldForm;
import com.example.simpleusersapi.User.UserLogin;

import java.util.List;

public interface UserService  {

    List<UserFieldForm> getAllUsers();
    UserFieldForm addUser(UserFieldForm userFieldForm);
    UserFieldForm findOne(String username);
}
