package com.edigest.journalApp.service;

import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Save or update user
    public void saveNewUser(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setUsername(user.getUsername());
            user.setRoles(List.of("USER"));
            userRepository.save(user);

    } public void saveAdmin(User user) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setUsername(user.getUsername());
            user.setRoles(List.of("USER","ADMIN"));
            userRepository.save(user);

    }
    public void saveUser(User user) {
            user.setUsername(user.getUsername());
            userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> findOne(ObjectId id) {
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id) {
        userRepository.deleteById(id);
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
