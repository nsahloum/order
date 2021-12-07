package com.switchfully.order.repository;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.service.dtos.CustomerDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepository {

    private final Map<String, Customer> customers = new HashMap<>();

    public Customer registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    public List<Customer> getAllCustomer() {
        return customers.values().stream().toList();
    }

    public Customer getCustomerById(String id) {
        return customers.get(id);
    }
}
