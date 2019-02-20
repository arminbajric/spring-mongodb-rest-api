package com.example.simpleusersapi.controller;

import com.example.simpleusersapi.User.UserFieldForm;

import com.example.simpleusersapi.User.UserLogin;
import com.example.simpleusersapi.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@RestController

public class UserController {

   public final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    List<UserFieldForm> getAll(){

        return userService.getAllUsers();
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
    public ResponseEntity getUser( HttpServletResponse response,@RequestBody UserLogin data){

        System.out.println(data.getEmail());
        if(userService.findOne(data.getEmail())!=null)
        {

            String UserToken=Jwts.builder().setSubject(data.getEmail()).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
            return ResponseEntity.status(201).header("Content-Type", "application/json; charset=UTF-8")
                    .header("Authorization",UserToken)
                    .body(userService.findOne(data.getEmail()));
        }
        else{

            data.setEmail("");
            data.setPassword("");
            return new ResponseEntity(data,HttpStatus.OK);
        }



    }
}
