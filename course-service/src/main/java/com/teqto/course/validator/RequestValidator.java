package com.teqto.course.validator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.teqto.course.constant.AuthConstant;
import com.teqto.course.entity.User;
@Repository(value = "requestValidator")
public class RequestValidator implements IRequestValidator {

	@Autowired
	RestTemplate restTemplate;
	@Override
	public User getUserFromRequest(HttpServletRequest request) {		
		String header = request.getHeader(AuthConstant.HEADER_STRING);
        String authToken = null;
        User user = null;
        if (header != null && header.startsWith(AuthConstant.TOKEN_PREFIX)) {
            authToken = header.replace(AuthConstant.TOKEN_PREFIX,""); 
            String url = "http://localhost:8081/public/users/"+authToken+"/";
            user = restTemplate.getForObject(url, User.class);
  //          user = userRepository.findByAuthtoken(authToken);
        }
        return user;
	}

}
