package com.example.api.services;

import com.example.api.domain.LoginRequest;
import com.example.api.domain.User;
import com.example.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User login(LoginRequest loginRequest){
        User user = new User();
        boolean usernameExist = userRepository.usernameExist(loginRequest.getUsername());

        if (usernameExist == false){
            return null;
        }
        boolean passwordExist = userRepository.passwordExist(loginRequest.getPassword());

        if(passwordExist == false){
            return null;
        }

        return userRepository.findByUsername(loginRequest.getUsername());
    }
}
