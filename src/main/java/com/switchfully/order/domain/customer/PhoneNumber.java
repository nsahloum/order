package com.switchfully.order.domain.customer;

import com.switchfully.order.service.dtos.customer.PhoneNumberDTO;

public class PhoneNumber {
    private String prefix;
    private String number;

    public PhoneNumber(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public PhoneNumber(PhoneNumberDTO phoneNumber){
        this.prefix = phoneNumber.getPrefix();
        this.number = phoneNumber.getNumber();
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }
}
