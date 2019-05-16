package com.sti.bootcamp.banking.config.security;

import com.sti.bootcamp.banking.db.model.CustomerEntity;
import com.sti.bootcamp.banking.db.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CustomTokenEnhancer implements TokenEnhancer {
//    @Autowired
//    private CustomerRepository customerRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        Map<String, Object> additionalInfo = new HashMap<>();
//        CustomerEntity customer = customerRepository.findByUsername(authentication.getName());

        UserDetails user = (UserDetails) authentication.getPrincipal();
        CustomUser customer = (CustomUser) user;

        additionalInfo.put("generated_time", System.currentTimeMillis());
        additionalInfo.put("username", customer.getUsername());
        additionalInfo.put("firstname", customer.getFirstname());
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}