package com.eda.example.eda.service;

import com.eda.example.eda.entity.Customer;
import org.springframework.stereotype.Service;

/**
 * @author amejia
 */
@Service
public class CustomerService {
    
    private final CustomerEventsService customerEventsService;


    public CustomerService(CustomerEventsService customerEventsService) {
        super();
        this.customerEventsService = customerEventsService;
    }
    
    public Customer save(Customer customer) {
        System.out.println("Receive "+customer);
        this.customerEventsService.publish(customer);
        return customer;
    }
}
