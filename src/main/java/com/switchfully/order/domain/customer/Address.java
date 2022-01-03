package com.switchfully.order.domain.customer;

import com.switchfully.order.service.dtos.customer.AddressDTO;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(generator = "address_seq")
    private int id;
    @Column(name = "street_name")
    private String streetName;
    @Column(name = "street_number")
    private int streetNumber;
    @Column(name = "post_code")
    private int postCode;
    @Column(name = "city")
    private String city;

    public Address() {
    }

    public Address(AddressDTO address){
        this.streetName = address.getStreetName();
        this.streetNumber = address.getStreetNumber();
        this.postCode = address.getPostCode();
        this.city = address.getCity();
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getPostCode() {
        return postCode;
    }

    public String getCity() {
        return city;
    }
}
