package com.sti.bootcamp.banking.db.dao;

import com.sti.bootcamp.banking.db.model.CustomerEntity;

import java.util.List;

public interface CustomerDao {
    CustomerEntity getById(int id);
    CustomerEntity Login(CustomerEntity customer);
}
