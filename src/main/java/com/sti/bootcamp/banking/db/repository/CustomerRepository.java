package com.sti.bootcamp.banking.db.repository;

import com.sti.bootcamp.banking.db.model.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
    CustomerEntity findByUsernameAndPassword(String username, String password);
    CustomerEntity findByUsername(String username);
}
