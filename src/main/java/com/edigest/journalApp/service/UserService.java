package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
     private UserRepository userRepository;
// save user in database
    public void saveEntry(User user){ userRepository.save(user); }
// list all users
    public List<User> getAll(){ return userRepository.findAll(); }
// find user by id
    public Optional<User> findOne(ObjectId id){ return userRepository.findById(id); }
// delete user by id
    public void deleteById(ObjectId id){ userRepository.deleteById(id); }
// find by username
    public User findByUserName(String username){
        return userRepository.findByUsername(username);
    }
}
