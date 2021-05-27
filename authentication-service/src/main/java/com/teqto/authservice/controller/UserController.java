package com.teqto.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teqto.authservice.model.LoginUser;
import com.teqto.authservice.model.User;
import com.teqto.authservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/signup")
    public User saveUser(@RequestBody LoginUser user){
      return userService.save(user);
    }
    // Other methods
}