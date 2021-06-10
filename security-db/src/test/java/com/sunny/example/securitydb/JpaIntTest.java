package com.sunny.example.securitydb;

import java.util.Optional;

import com.sunny.example.securitydb.domain.Address;
import com.sunny.example.securitydb.domain.Person;
import com.sunny.example.securitydb.repository.AddressRepository;
import com.sunny.example.securitydb.repository.PersonRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
//@DataJpaTest
@SpringBootTest
public class JpaIntTest {
    
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;
    @Test
    public void testAddressRepo(){
        Address add1 = new Address();
        add1.setCountry("CH");
        add1.setCity("ZH");
        add1.setZip(8001);
        add1.setStreet("Backstr");
        Address add2 = new Address();
        add2.setCountry("CH");
        add2.setCity("ZH");
        add2.setZip(8001);
        add2.setStreet("Bahnhofstr");
        addressRepository.saveAndFlush(add1); 
    }

    @Test
    public void updateAddress(){
        Optional<Address> res = addressRepository.findById(2L);
        Person pers1 = new Person();
        pers1.setFirstName("Lisa");
        pers1.setListName("Hu");
        pers1.setAddress(res.get());
        personRepository.saveAndFlush(pers1);
        Address add1 = new Address();
        add1.setCountry("DE");
        add1.setCity("MU");
        add1.setZip(9005);
        add1.setStreet("Ellistr");
        Address savedAdd = addressRepository.saveAndFlush(add1);
        Person pers2 = new Person();
        pers2.setFirstName("Xi");
        pers2.setListName("Su");
        pers2.setAddress(savedAdd);
        personRepository.saveAndFlush(pers2);
    }
}
