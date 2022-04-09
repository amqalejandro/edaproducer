package com.eda.example.eda.event;

import com.eda.example.eda.entity.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author amejia
 */
@Data
@EqualsAndHashCode(callSuper =true)
public class CustomerCreatedEvent extends Event<Customer>{
}
