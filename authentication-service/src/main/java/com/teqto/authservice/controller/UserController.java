package com.teqto.authservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teqto.authservice.model.LoginUser;
import com.teqto.authservice.model.User;
import com.teqto.authservice.repository.UserRepository;
import com.teqto.authservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/signup")
    public User saveUser(@RequestBody LoginUser user){
      return userService.save(user);
    }
    // Other methods
    
    @GetMapping("/public/{token}/")
    public ResponseEntity<User> getUser(@PathVariable("token") String token){    	
           User user = userRepository.findByAuthtoken(token);     
           return new ResponseEntity<>(user, HttpStatus.OK);
    }
}