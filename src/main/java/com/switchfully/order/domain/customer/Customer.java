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
    private String username;
    private String password;

    public Customer(String firstname, String lastname, String email, Address address, PhoneNumber phoneNumber, String username, String password) {
        this.id = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.username = username;
    }

    public Customer(CustomerDTO customerDTO){
        this.id = customerDTO.getId();
        this.firstname = customerDTO.getFirstname();
        this.lastname = customerDTO.getLastname();
        this.email = customerDTO.getEmail();
        this.address = customerDTO.getAddress();
        this.phoneNumber = customerDTO.getPhoneNumber();
        this.username = customerDTO.getUsername();
        this.password = customerDTO.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
