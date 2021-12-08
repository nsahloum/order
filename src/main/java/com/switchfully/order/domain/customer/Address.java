package com.switchfully.order.domain.customer;

import com.switchfully.order.service.dtos.customer.AddressDTO;

public class Address {
    private String streetName;
    private int streetNumber;
    private int postCode;
    private String city;

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
