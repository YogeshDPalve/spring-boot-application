package com.edigest.journalApp.controller;

import com.edigest.journalApp.api.responce.TodoResponce;
import com.edigest.journalApp.entity.JournalEntry;
import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.service.JournalEntryService;
import com.edigest.journalApp.service.TodoService;
import com.edigest.journalApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TodoService todoService;
    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        User userInDb = userService.findByUserName(username);
        userInDb.setUsername(user.getUsername());
        userInDb.setPassword(user.getPassword());

        userService.saveUser(userInDb);
        return ResponseEntity.ok(userInDb);
    }

    @GetMapping("/todo")
    public ResponseEntity<?> getTodos(){
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        TodoResponce todos = todoService.getTodos();

        return ResponseEntity.ok().body(todos);
    }

}
