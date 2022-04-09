package com.eda.example.eda.web;

import com.eda.example.eda.entity.Customer;
import com.eda.example.eda.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author amejia
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {
    
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        super();
        this.customerService = customerService;
    }
    
    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return this.customerService.save(customer);
    }
}
