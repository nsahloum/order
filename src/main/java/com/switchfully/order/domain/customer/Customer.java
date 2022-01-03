package com.switchfully.order.domain.customer;

import com.switchfully.order.service.dtos.customer.CustomerDTO;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(generator = "customer_seq")
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @JoinColumn(name = "fk_address")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Address address;
    @JoinColumn(name = "fk_phone_number")
    @ManyToOne(cascade = {CascadeType.ALL})
    private PhoneNumber phoneNumber;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Customer() {
    }

    public Customer(CustomerDTO customerDTO) {
        this.id = customerDTO.getId();
        this.firstName = customerDTO.getFirstName();
        this.lastName = customerDTO.getLastName();
        this.email = customerDTO.getEmail();
        this.address = new Address(customerDTO.getAddress());
        this.phoneNumber = new PhoneNumber(customerDTO.getPhoneNumber());
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

    public int getId() {
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
