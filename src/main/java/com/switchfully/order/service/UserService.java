package com.switchfully.order.service;

import com.switchfully.order.repository.UserRepository;
import com.switchfully.order.service.dtos.CustomerDTO;
import com.switchfully.order.service.mappers.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public CustomerDTO registerCustomer(CustomerDTO customerDTO) {
        userRepository.registerCustomer(userMapper.mapToCustomer(customerDTO));
        return customerDTO;
    }
}
