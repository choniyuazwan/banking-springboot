package com.sti.bootcamp.banking.db.repository;

import com.sti.bootcamp.banking.db.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
