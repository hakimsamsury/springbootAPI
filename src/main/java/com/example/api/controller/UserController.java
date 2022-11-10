package com.example.api.controller;

import com.example.api.domain.LoginRequest;
import com.example.api.domain.User;
import com.example.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping
    public List<User> getAllUsers(){
       return userService.getAllUsers();
    }
    @PostMapping
    public void setUser(@RequestBody User user){
        userService.addUser(user);
    }

}
