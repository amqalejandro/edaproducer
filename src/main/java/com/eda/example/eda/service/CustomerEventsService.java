package com.eda.example.eda.service;

import com.eda.example.eda.entity.Customer;
import com.eda.example.eda.event.CustomerCreatedEvent;
import com.eda.example.eda.event.Event;
import com.eda.example.eda.event.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author amejia
 */
@Component
public class CustomerEventsService {
    
    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:customers}")    
    private String topicCustomer;
    
    public void publish(Customer customer){
        
        CustomerCreatedEvent created=new CustomerCreatedEvent();
        created.setData(customer);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());
        
        this.producer.send(topicCustomer,created);
    }
}
