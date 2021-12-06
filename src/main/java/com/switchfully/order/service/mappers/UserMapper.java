package com.switchfully.order.service.mappers;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.service.dtos.CustomerDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public CustomerDTO mapToDTO (Customer customer){
        return new CustomerDTO(customer);
    }

    public Customer mapToCustomer (CustomerDTO customerDTO){
        return new Customer(customerDTO);
    }
}
