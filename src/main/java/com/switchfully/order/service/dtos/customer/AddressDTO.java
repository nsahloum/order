package com.switchfully.order.service.dtos.customer;

import com.switchfully.order.domain.customer.Address;

public class AddressDTO {
    private String streetName;
    private int streetNumber;
    private int postCode;
    private String city;

    public AddressDTO(String streetName, int streetNumber, int postCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
    }

    public AddressDTO(Address address) {
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
