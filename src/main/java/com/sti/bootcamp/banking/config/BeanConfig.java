package com.sti.bootcamp.banking.config;

import com.sti.bootcamp.banking.db.dao.AccountDao;
import com.sti.bootcamp.banking.db.dao.CustomerDao;
import com.sti.bootcamp.banking.db.dao.WalletDao;
import com.sti.bootcamp.banking.db.dao.impl.AccountDaoImpl;
import com.sti.bootcamp.banking.db.dao.impl.CustomerDaoImpl;
import com.sti.bootcamp.banking.db.dao.impl.WalletDaoImpl;
import org.springframework.context.annotation.Bean;

public class BeanConfig {

    @Bean
    public CustomerDao customerDao() {
        return new CustomerDaoImpl();
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDaoImpl();
    }

    @Bean
    public WalletDao walletDao() {
        return new WalletDaoImpl();
    }
}
