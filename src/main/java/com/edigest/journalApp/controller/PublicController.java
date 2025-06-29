package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("/health-check")
    public  String healthCheck(){return "ok";}

    @PostMapping("/new")
    public void createNewUser(@RequestBody User user){ userService.saveNewUser(user);}


    @GetMapping("/all")
    public List<User> getAllUsers(){ return userService.getAll();}
}
