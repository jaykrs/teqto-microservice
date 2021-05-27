package com.teqto.authservice.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.teqto.authservice.model.LoginUser;
import com.teqto.authservice.model.User;
import com.teqto.authservice.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {
   @Autowired
   private UserRepository userDao;   
   @Autowired
   private BCryptPasswordEncoder passwordEncoder;      

@Override
   public User save(LoginUser user) {
         User newUser = new User();
         newUser.setUsername(user.getUsername());
         newUser.setPassword(passwordEncoder.encode(user.getPassword()));
         newUser.setName(user.getName());
         return userDao.save(newUser);
    }
   public UserDetails loadUserByUsername(String userId) throws
               UsernameNotFoundException {
         User user = userDao.findByUsername(userId);
         if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
         }
         return new org.springframework.security.core.userdetails.User(
            user.getUsername(), user.getPassword(), getAuthority());
         }
private Collection<? extends GrantedAuthority> getAuthority() {
	List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
	return list;
}
@Override
public User findOne(String username) {
	return userDao.findByUsername(username);
}
@Override
public User save(User user) {
	return userDao.save(user);
}
   
}