package com.switchfully.order.domain.customer;

import com.switchfully.order.service.dtos.CustomerDTO;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String email;
    private final Address address;
    private final PhoneNumber phoneNumber;

    public Customer(String firstname, String lastname, String email, Address address, PhoneNumber phoneNumber) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Customer(CustomerDTO customerDTO){
        this.id = customerDTO.getId();
        this.firstname = customerDTO.getFirstname();
        this.lastname = customerDTO.getLastname();
        this.email = customerDTO.getEmail();
        this.address = customerDTO.getAddress();
        this.phoneNumber = customerDTO.getPhoneNumber();
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
