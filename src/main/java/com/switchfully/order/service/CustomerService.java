package com.switchfully.order.service;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.repository.CustomerRepository;
import com.switchfully.order.service.dtos.CustomerDTO;
import com.switchfully.order.service.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO registerCustomerDTO(CustomerDTO customerDTO) {
        Customer customerSaved = customerRepository.registerCustomer(customerMapper.mapToCustomer(customerDTO));
        return customerMapper.mapToDTO(customerSaved);
    }

    public List<CustomerDTO> getAllCustomerDTO(){
        return customerMapper.convertCustomerMapToDtoList(customerRepository.getAllCustomer());
    }

    public CustomerDTO getCustomerById(String id) {
        return customerMapper.mapToDTO(customerRepository.getCustomerById(id));
    }
}
