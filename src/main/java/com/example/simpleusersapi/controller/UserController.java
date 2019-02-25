package com.example.simpleusersapi.controller;

import com.example.simpleusersapi.User.UserFieldForm;

import com.example.simpleusersapi.User.UserLogin;

import com.example.simpleusersapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;


@RestController
public class UserController {

   private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }



    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserFieldForm addUser(@RequestBody UserFieldForm userFieldForm)
    {

       return userService.addUser(userFieldForm);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/login", method = RequestMethod.POST,headers="Accept=application/json")
    public ResponseEntity getUser( @RequestBody UserLogin data){

        System.out.println(data.getEmail());
        if(userService.findOne(data.getEmail())!=null) {
            if (userService.findOne(data.getEmail()).getRole().equals("admin"))
            {
                System.out.println(userService.findOne(data.getEmail()).getRole());
                String UserToken=Jwts.builder().setSubject(data.getEmail()).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
                return ResponseEntity.status(201).header("Content-Type", "application/json; charset=UTF-8")
                        .header("AdminUser",UserToken)
                        .body(userService.findOne(data.getEmail()));
            }
            else {
                String UserToken = Jwts.builder().setSubject(data.getEmail()).setIssuedAt(new Date())
                        .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
                return ResponseEntity.status(201).header("Content-Type", "application/json; charset=UTF-8")
                        .header("RegularUser", UserToken)
                        .body(userService.findOne(data.getEmail()));
            }
        }
        else{

            data.setEmail("");
            data.setPassword("");
            return new ResponseEntity(data,HttpStatus.OK);
        }



    }
}
