package com.switchfully.order.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.domain.customer.Address;
import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.PhoneNumber;

import java.util.UUID;

public class CustomerDTO {
    private final String id;
    private final String firstName;
    private final String lastName;
    private String username;
    private final String email;
    private final Address address;
    private final PhoneNumber phoneNumber;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public CustomerDTO(String firstName, String lastName, String email, Address address, PhoneNumber phoneNumber, String password, String username) {
        this.id = UUID.randomUUID().toString();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.username = username;
    }

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.firstName = customer.getFirstName();
        this.lastName = customer.getLastName();
        this.email = customer.getEmail();
        this.address = customer.getAddress();
        this.phoneNumber = customer.getPhoneNumber();
        this.username = customer.getUsername();
        this.password = customer.getPassword();
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
