package com.switchfully.order.service.dtos.customer;

import com.switchfully.order.domain.customer.PhoneNumber;

import java.util.Objects;

public class PhoneNumberDTO {
    private String prefix;
    private String number;

    public PhoneNumberDTO(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public PhoneNumberDTO(PhoneNumber phoneNumber){
        this.prefix = phoneNumber.getPrefix();
        this.number = phoneNumber.getNumber();
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumberDTO that = (PhoneNumberDTO) o;
        return Objects.equals(prefix, that.prefix) && Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, number);
    }
}
