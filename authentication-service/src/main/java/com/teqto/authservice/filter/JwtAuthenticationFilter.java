package com.teqto.authservice.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.teqto.authservice.jwt.JwtTokenUtil;
import com.teqto.authservice.constant.AuthConstant;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse 
                 res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(AuthConstant.HEADER_STRING);
        String username = null;
        String authToken = null;
        if (header != null && header.startsWith(AuthConstant.TOKEN_PREFIX)) {
            authToken = header.replace(AuthConstant.TOKEN_PREFIX,"");
            try {
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            } catch (IllegalArgumentException e) {
                logger.error("An error occured during getting username from token", e);
            } catch (ExpiredJwtException e) {
                logger.warn("Token is expired and not valid anymore", e);
            } catch(SignatureException e){
                logger.error("Authentication Failed. Username or Password not valid.");
            }
        } else {
            logger.warn("Couldn't find bearer string, will ignore the header");
        }
        if (username != null && 
                 SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = 
                          userDetailsService.loadUserByUsername(username);
            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
                UsernamePasswordAuthenticationToken authentication = new 
                     UsernamePasswordAuthenticationToken(userDetails, null, null);
                authentication.setDetails(new 
                     WebAuthenticationDetailsSource().buildDetails(req));
                logger.info("Authenticated user " + username + ", setting security context");                          
                SecurityContextHolder.getContext().setAuthentication(
                          authentication);
            }
        }
        chain.doFilter(req, res);
    }
}