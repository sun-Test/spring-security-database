package com.sunny.example.securitydb.service;

import com.sunny.example.securitydb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.sunny.example.securitydb.domain.*;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Boolean initUser(String initUsername, String initPassword) {
        if(!userRepository.exists(QUser.user.username.eq(initUsername))) {
            User transUser = new User();
            transUser.setUsername(initUsername);
            transUser.setPassword(new BCryptPasswordEncoder().encode(initPassword));
            userRepository.saveAndFlush(transUser);
            return true;
        }
        return false;
    }
}
