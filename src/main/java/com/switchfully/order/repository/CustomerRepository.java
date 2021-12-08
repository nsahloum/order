package com.switchfully.order.repository;

import com.switchfully.order.domain.customer.Customer;
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

    public Customer getCustomerByUsername(String username) {
        return customers.values().stream()
                .filter(customer -> customer.getUsername().equals(username))
                .findFirst().orElse(null);
    }

    public Customer getCustomerByEmail(String email) {
        return customers.values().stream()
                .filter(customer -> customer.getEmail().equals(email))
                .findFirst().orElse(null);
    }
}
