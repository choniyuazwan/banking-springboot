package com.sti.bootcamp.banking.db.dao.impl;

import com.sti.bootcamp.banking.db.dao.CustomerDao;
import com.sti.bootcamp.banking.db.model.CustomerEntity;
import com.sti.bootcamp.banking.db.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerEntity getById(int id) {
        return em.find(CustomerEntity.class, id);
    }

    @Override
    public CustomerEntity Login(CustomerEntity customer) {
        CustomerEntity customers;
        customers = customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());

        return null;
    }
}
