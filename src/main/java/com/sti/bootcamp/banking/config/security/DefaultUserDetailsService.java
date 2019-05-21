package com.sti.bootcamp.banking.config.security;
import java.util.Arrays;
import java.util.List;

import com.sti.bootcamp.banking.db.dao.CustomerDao;
import com.sti.bootcamp.banking.db.model.CustomerEntity;
import com.sti.bootcamp.banking.db.repository.CustomerRepository;
import com.sti.bootcamp.banking.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return mockUser(username);
    }

    private UserDetails mockUser(String username) {
        try {
//            CustomerEntity customer = customerDao.getByUsername(username);
            CustomerEntity customer = customerRepository.findByUsername(username);
            if (customer == null) {
                throw new CustomException("99", "Failed");
            }

//            return new User(customer.getUsername(), String.format("{noop}%s", customer.getPassword()), getAuthority());
            return new CustomUser(customer, getAuthority());
        }catch (CustomException e) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private List getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }
}
