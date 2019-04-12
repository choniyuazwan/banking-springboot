package com.sti.bootcamp.banking.config;

import com.sti.bootcamp.banking.db.dao.*;
import com.sti.bootcamp.banking.db.dao.impl.*;
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

    @Bean
    public WalletAccountDao walletAccountDao() {
        return new WalletAccountDaoImpl();
    }

    @Bean
    public TransactionDao transactionDao() {
        return new TransactionDaoImpl();
    }
}
