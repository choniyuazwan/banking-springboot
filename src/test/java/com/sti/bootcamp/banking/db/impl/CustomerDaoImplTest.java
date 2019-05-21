package com.sti.bootcamp.banking.db.impl;

import com.sti.bootcamp.banking.db.dao.CustomerDao;
import com.sti.bootcamp.banking.db.model.CustomerEntity;
import com.sti.bootcamp.banking.db.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CustomerDaoImplTest {
    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerRepository customerRepository;

    @PersistenceContext
    private EntityManager em;

    @Before
    public void setUp() {
        for (int i = 0; i < 5; i++) {
            int row = i + 1;
            CustomerEntity cus = new CustomerEntity();
            cus.setCif(row);
            cus.setFirstname(String.format("firstname %s", row));
            cus.setLastname(String.format("lastname %s", row));
            cus.setBirthdate(String.valueOf(new Date(1997, row, row)));
            cus.setUsername(String.format("username %s", row));
            cus.setPassword(String.format("password %s", row));
            em.merge(cus);
//            customerRepository.save(cus);
        }
    }

    @Test
    public void testGetByUsername() {
        CustomerEntity customer = customerRepository.findByUsername("username 2");
        assertNotNull(customer);
    }
}
