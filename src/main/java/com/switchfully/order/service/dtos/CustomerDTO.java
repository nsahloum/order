package com.switchfully.order.service.dtos;

import com.switchfully.order.domain.customer.Address;
import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.PhoneNumber;

import java.util.UUID;

public class CustomerDTO {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Address address;
    private final PhoneNumber phoneNumber;

    public CustomerDTO(String firstname, String lastname, String email, Address address, PhoneNumber phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.firstname = customer.getFirstname();
        this.lastname = customer.getLastname();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.phoneNumber = customer.getPhoneNumber();
    }


    public String getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }


    public Address getAddress() {
        return address;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
}
