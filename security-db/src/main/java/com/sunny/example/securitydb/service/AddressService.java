package com.sunny.example.securitydb.service;

import com.sunny.example.securitydb.repository.AddressRepository;
import com.sunny.example.securitydb.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

import com.sunny.example.securitydb.domain.*;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }

        
}