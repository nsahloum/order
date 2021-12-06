package com.switchfully.order.domain.customer;

public class Address {
    private String streetName;
    private int streetNumber;
    private int postCode;
    private String city;

    public Address(String streetName, int streetNumber, int postCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city;
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
