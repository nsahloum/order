package com.switchfully.order.repository;

import com.switchfully.order.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer save(Customer customer);

    List<Customer> findAll();

    Customer findById(int id);

    Customer findCustomerByUsername(String username);

    Customer findCustomerByEmail(String email);
}
