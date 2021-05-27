package com.teqto.authservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teqto.authservice.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
	User findByAuthtoken(String authtoken);
}
 