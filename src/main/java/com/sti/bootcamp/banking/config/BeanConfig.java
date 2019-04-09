package com.sti.bootcamp.banking.config;

import com.sti.bootcamp.banking.db.dao.CustomerDao;
import com.sti.bootcamp.banking.db.dao.impl.CustomerDaoImpl;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public CustomerDao customerDao() {
        return new CustomerDaoImpl();
    }

}
