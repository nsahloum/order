package com.switchfully.order.service;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.exceptions.NotUniqException;
import com.switchfully.order.exceptions.UnauthorizedException;
import com.switchfully.order.repository.CustomerRepository;
import com.switchfully.order.service.dtos.CustomerDTO;
import com.switchfully.order.service.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;
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
        if (customerRepository.getCustomerByUsername(customerDTO.getUsername()) != null){
            throw new NotUniqException("Your username is not uniq");
        }
        if (customerRepository.getCustomerByEmail(customerDTO.getEmail()) != null){
            throw new NotUniqException("Your email is not uniq");
        }
        Customer customerSaved = customerRepository.registerCustomer(customerMapper.mapToCustomer(customerDTO));
        return customerMapper.mapToDTO(customerSaved);
    }

    public List<CustomerDTO> getAllCustomerDTO(){
        return customerMapper.convertCustomerMapToDtoList(customerRepository.getAllCustomer());
    }

    public CustomerDTO getCustomerById(String id) {
        return customerMapper.mapToDTO(customerRepository.getCustomerById(id));
    }

    public CustomerDTO findCustomerLoggedIn(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        Customer customer = customerRepository.getCustomerByUsername(username);
        if (customer == null){
            throw new UnauthorizedException("You are not logged in");
        }
        return customerMapper.mapToDTO(customer);
    }
}
