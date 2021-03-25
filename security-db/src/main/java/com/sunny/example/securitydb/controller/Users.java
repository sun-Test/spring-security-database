package com.sunny.example.securitydb.controller;

import com.sunny.example.securitydb.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("users")
public class Users {

    @Value("${sunny.side.app.adminUsername}")
	private String initUsername;
    @Value("${sunny.side.app.adminPassword}")
	private String initPassword;

    @Autowired
    private UserService userService;

    @GetMapping("init")
    public ResponseEntity<Boolean> initUser() {
        return ResponseEntity.ok(userService.initUser(initUsername, initPassword));
    }

    
}
