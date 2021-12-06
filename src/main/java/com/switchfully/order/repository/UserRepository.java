package com.switchfully.order.repository;

import com.switchfully.order.domain.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {

    private final Map<String, Customer> customers = new HashMap<>();

    public void registerCustomer(Customer customer) {
        customers.put(customer.getId(), customer);
    }
}
