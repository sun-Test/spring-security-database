package com.sunny.example.securitydb.security;


import java.util.ArrayList;
import java.util.Optional;

import com.sunny.example.securitydb.domain.QUser;
import com.sunny.example.securitydb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<com.sunny.example.securitydb.domain.User> user = userRepository.findOne(QUser.user.username.eq(s));
        if(user.isPresent()) {
            return new User(user.get().getUsername(), user.get().getPassword(), new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("user name is not found");
        }
    }

}
