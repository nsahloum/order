package com.switchfully.order.service;

import com.switchfully.order.domain.admin.Admin;
import com.switchfully.order.exceptions.UnauthorizedException;
import com.switchfully.order.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class AdminService {
    AdminRepository adminRepository;
    Admin admin;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
        this.admin = adminRepository.getAdmin();
    }

    public void checkIfAdmin(String authorization) {
        String decodedUsernameAndPassword = new String(Base64.getDecoder().decode(authorization.substring("Basic ".length())));
        String username = decodedUsernameAndPassword.substring(0, decodedUsernameAndPassword.indexOf(":"));
        String password = decodedUsernameAndPassword.substring(decodedUsernameAndPassword.indexOf(":") + 1);
        if (!username.equals(admin.getUsername()) || !password.equals(admin.getPassword())) {
            throw new UnauthorizedException();
        }
    }
}
