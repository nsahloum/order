package com.switchfully.order.service;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.exceptions.NotUniqException;
import com.switchfully.order.exceptions.UnauthorizedException;
import com.switchfully.order.repository.CustomerRepository;
import com.switchfully.order.service.dtos.customer.CustomerDTO;
import com.switchfully.order.service.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO registerCustomerDTO(CustomerDTO customerDTO) {
        if (customerRepository.findCustomerByUsername(customerDTO.getUsername()) != null){
            throw new NotUniqException("Your username is not uniq");
        }
        if (customerRepository.findCustomerByEmail(customerDTO.getEmail()) != null){
            throw new NotUniqException("Your email is not uniq");
        }
        Customer customerSaved = customerRepository.save(customerMapper.mapToCustomer(customerDTO));
        return customerMapper.mapToDTO(customerSaved);
    }

    public List<CustomerDTO> getAllCustomerDTO(){
        return customerMapper.convertCustomerMapToDtoList(customerRepository.findAll());
    }

    public CustomerDTO getCustomerById(int id) {
        if (customerRepository.findById(id) == null){
            throw new NoSuchElementException("No customer with this ID");
        }
        return customerMapper.mapToDTO(customerRepository.findById(id));
    }

    public CustomerDTO findCustomerLoggedIn(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        Customer customer = customerRepository.findCustomerByUsername(username);
        if (customer == null){
            throw new UnauthorizedException("You are not logged in");
        }
        return customerMapper.mapToDTO(customer);
    }
}
