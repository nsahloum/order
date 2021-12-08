package com.switchfully.order.service;

import com.switchfully.order.domain.admin.Admin;
import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.exceptions.UnauthorizedException;
import com.switchfully.order.repository.AdminRepository;
import com.switchfully.order.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class SecurityService {
    AdminRepository adminRepository;
    Admin admin;
    CustomerRepository customerRepository;

    public SecurityService(AdminRepository adminRepository, CustomerRepository customerRepository) {
        this.adminRepository = adminRepository;
        this.admin = adminRepository.getAdmin();
        this.customerRepository = customerRepository;
    }

    public void checkIfAdmin(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        if (!username.equals(admin.getUsername()) || !password.equals(admin.getPassword())){
            throw new UnauthorizedException();
        }
    }
}
