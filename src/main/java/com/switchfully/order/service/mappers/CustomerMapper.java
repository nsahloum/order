package com.switchfully.order.service.mappers;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.service.dtos.CustomerDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapper {
    public CustomerDTO mapToDTO (Customer customer){
        return new CustomerDTO(customer);
    }

    public Customer mapToCustomer (CustomerDTO customerDTO){
        return new Customer(customerDTO);
    }

    public List<CustomerDTO> convertCustomerMapToDtoList (List <Customer> customers){
        return customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
    }
}
