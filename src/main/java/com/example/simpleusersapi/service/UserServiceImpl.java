package com.example.simpleusersapi.service;

import com.example.simpleusersapi.User.UserFieldForm;
import com.example.simpleusersapi.User.UserLogin;
import com.example.simpleusersapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserFieldForm> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserFieldForm addUser(UserFieldForm userFieldForm) {
        return userRepository.save(userFieldForm);
    }

    @Override
    public UserFieldForm findOne(String email) {
        return userRepository.findByEmail(email);
    }


}
