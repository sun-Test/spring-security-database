package com.sunny.example.securitydb.graphql.resolvers;

import com.sunny.example.securitydb.domain.*;
import com.sunny.example.securitydb.service.AddressService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Service
public class AddressResolver implements GraphQLQueryResolver{
    @Autowired
    AddressService addressService;

    public Collection<Address> address(){
        return addressService.getAllAddress();
    }
    
}
