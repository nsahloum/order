package com.switchfully.order.service.dtos.customer;

import com.switchfully.order.domain.customer.Address;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDTO that = (AddressDTO) o;
        return streetNumber == that.streetNumber && postCode == that.postCode && Objects.equals(streetName, that.streetName) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetName, streetNumber, postCode, city);
    }
}
