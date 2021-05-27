package com.teqto.authservice.service;

import com.teqto.authservice.model.LoginUser;
import com.teqto.authservice.model.User;

public interface UserService {

	User save(LoginUser user);
	User findOne(String username);
	User save(User user);

}
