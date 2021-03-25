package com.sunny.example.securitydb.controller;

import java.util.HashMap;

import com.sunny.example.securitydb.dto.AuthenticationRequest;
import com.sunny.example.securitydb.dto.AuthenticationResponse;
import com.sunny.example.securitydb.security.JwtUtils;
import com.sunny.example.securitydb.security.UserDetailsServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class Authentication {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value="/authenticate", method=RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), 
            authenticationRequest.getPassword()));
        } catch(BadCredentialsException e) {
            return new ResponseEntity<>("wrong username or password", HttpStatus.UNAUTHORIZED);
        }         
        final UserDetails details = userDetailsServiceImpl.loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtils.generateJwtToken(details, new HashMap<>());
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
    
    
}
