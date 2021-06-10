package com.sunny.example.securitydb.controller;

import java.util.List;

import com.sunny.example.securitydb.domain.Address;
import com.sunny.example.securitydb.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("address")
public class Addresses {


    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress() {
        return ResponseEntity.ok(addressService.getAllAddress());
    }
/*
    @PostMapping("graphql")
    public getAllAddressGql(@RequestBody String query){}
*/
    
}
