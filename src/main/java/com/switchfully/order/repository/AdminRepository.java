package com.switchfully.order.repository;

import com.switchfully.order.domain.admin.Admin;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepository {
    private final Admin admin;

    public AdminRepository() {
        this.admin = new Admin("user", "password");
    }

    public Admin getAdmin() {
        return admin;
    }
}
