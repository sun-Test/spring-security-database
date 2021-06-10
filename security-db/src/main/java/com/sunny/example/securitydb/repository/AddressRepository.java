package com.sunny.example.securitydb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sunny.example.securitydb.domain.*;

@RepositoryRestResource(exported = false)
public interface AddressRepository extends JpaRepository<Address, Long>, QuerydslPredicateExecutor<Address>
{
}


