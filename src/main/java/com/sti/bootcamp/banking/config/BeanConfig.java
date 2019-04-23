package com.sti.bootcamp.banking.config;

import com.sti.bootcamp.banking.db.dao.*;
import com.sti.bootcamp.banking.db.dao.impl.*;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.Collections;

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

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }
}
