package com.sti.bootcamp.banking.controller;

import com.sti.bootcamp.banking.db.dao.CustomerDao;
import com.sti.bootcamp.banking.db.model.CustomerEntity;
import com.sti.bootcamp.banking.db.repository.CustomerRepository;
import com.sti.bootcamp.banking.model.dto.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    public static final String URL_REQUEST_CUSTOMER = "/customer";
    public static final String URL_REQUEST_CUSTOMER_LIST = "/customers";
    public static final String URL_REQUEST_CUSTOMER_BY_ID = "/customer/{id}";

    @Autowired
    private CustomerDao customerDao;

    @GetMapping(value = "/customers")
    public CommonResponse<List<CustomerEntity>> getAll() {
        CommonResponse<List<CustomerEntity>> response = new CommonResponse<>();
        List<CustomerEntity> customers = customerDao.getList();
        if (!customers.isEmpty()) {
            response.setData(customers);
            return response;
        } else {
            response.setResponsecode("04");
            response.setResponsemessage("Not Found");
            return response;
        }
    }

    @PostMapping(value = "/customer/add")
    public CommonResponse<CustomerEntity> addCustomerEntity(@RequestBody CustomerEntity customer) {
        CommonResponse<CustomerEntity> response = new CommonResponse<>();
        CustomerEntity customer1 = customerDao.save(customer);
        response.setData(customer1);
        return response;

    }
}
