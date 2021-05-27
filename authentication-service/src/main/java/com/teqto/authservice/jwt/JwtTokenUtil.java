package com.teqto.authservice.jwt;

import java.io.Serializable;
import java.util.Date;
import com.teqto.authservice.constant.AuthConstant;
import com.teqto.authservice.repository.UserRepository;
import com.teqto.authservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {    
    /**
	 * 
	 */
	
	@Autowired
    private UserRepository userRepository;
	
	private static final long serialVersionUID = 451477513041914303L;
	@Value("${jwt.security.key}")
    private String jwtKey;
    public String doGenerateToken(String subject) {
        Claims claims = Jwts.claims().setSubject(subject);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("http://jwtdemo.com")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() +           
                		AuthConstant.ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .signWith(SignatureAlgorithm.HS256, jwtKey)
                .compact();
    }
   // Other methods
	public String getUsernameFromToken(String authToken) {
		return userRepository.findByAuthtoken(authToken).getUsername();
	}
	public boolean validateToken(String authToken, UserDetails userDetails) {
		return getUsernameFromToken(authToken).equals(userDetails.getUsername())?true:false;
	}
}