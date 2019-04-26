package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.CustomerDao;
import com.sti.bootcamp.banking.db.model.CustomerEntity;
import com.sti.bootcamp.banking.db.repository.CustomerRepository;
import com.sti.bootcamp.banking.exception.CustomException;
import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    public static final String URL_REQUEST_CUSTOMER = "/customer";
    public static final String URL_REQUEST_CUSTOMER_LIST = "/customers";
    public static final String URL_REQUEST_CUSTOMER_BY_ID = "/customer/{id}";
    public static final String URL_REQUEST_CUSTOMER_BY_USERNAME_PASSWORD = "/customer/{username}/{password}";
    public static final String URL_REQUEST_CUSTOMER_LOGIN= "/customer/login";
    public static final String URL_REQUEST_CUSTOMER_BY_USERNAME= "/customer/{username}";

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = URL_REQUEST_CUSTOMER_BY_ID)
    public CommonResponse<CustomerEntity> getCustomerEntity(@PathVariable(name = "id") String id) throws CustomException {
        CustomerEntity customer = customerDao.getById(Integer.parseInt(id));
        CommonResponse<CustomerEntity> response = new CommonResponse<>();
        if (customer == null) {
            throw new CustomException("404", "Not Found");
        } else {
            response.setData(customer);
        }
        return response;
    }

//    @GetMapping(value = URL_REQUEST_CUSTOMER_BY_USERNAME_PASSWORD)
//    public CommonResponse<CustomerEntity> getCustomerEntity(@PathVariable(name = "username") String username, @PathVariable(name = "password") String password) throws CustomException {
//        CustomerEntity customers;
//        customers = customerRepository.findByUsernameAndPassword(username, password);
//
//        if ( customers == null) {
//            throw new CustomException("404", "Not Found");
//        }
//
//        CommonResponse<CustomerEntity> response = new CommonResponse<>();
//        response.setData(customers);
//        return response;
//    }


    @GetMapping(value = URL_REQUEST_CUSTOMER_LIST)
    public CommonResponse<List<CustomerEntity>> getCustomerList() throws CustomException {
        List<CustomerEntity> customers;
        customers = (List<CustomerEntity>) customerRepository.findAll();

        if (customers.isEmpty() || customers == null) {
            throw new CustomException("404", "Not Found");
        }

        CommonResponse<List<CustomerEntity>> response = new CommonResponse<>();
        response.setData(customers);
        return response;
    }

    @PostMapping(value = URL_REQUEST_CUSTOMER)
    public CommonResponse<CustomerEntity> createCustomerEntity(@RequestBody CustomerEntity customer) throws CustomException {
        CommonResponse<CustomerEntity> response = new CommonResponse<>();


        CustomerEntity checkCustomer;
        checkCustomer = customerRepository.findByUsername(customer.getUsername());

        if (checkCustomer != null) {
            throw new CustomException("404", "Email already exist");
        }

        response.setData(customerRepository.save(customer));
        return response;
    }

    @PostMapping(value = URL_REQUEST_CUSTOMER_LOGIN)
    public CommonResponse<CustomerEntity> login(@RequestBody CustomerEntity customer) throws CustomException {
        CustomerEntity customers;
        customers = customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());

        if (customers == null) {
            throw new CustomException("404", "Not Found");
        }

        CommonResponse<CustomerEntity> response = new CommonResponse<CustomerEntity>();
        response.setData(customers);
        return response;
    }

    @PostMapping(value = URL_REQUEST_CUSTOMER_BY_USERNAME)
    public CommonResponse<CustomerEntity> getCustomerByUsername(@RequestBody CustomerEntity customer) throws CustomException {
        CustomerEntity checkCustomer;
        checkCustomer = customerRepository.findByUsername(customer.getUsername());

        if (checkCustomer != null) {
            throw new CustomException("100", "Already Exists");
        }

        CommonResponse<CustomerEntity> response = new CommonResponse<CustomerEntity>();
        response.setData(checkCustomer);
        return response;
    }
}
