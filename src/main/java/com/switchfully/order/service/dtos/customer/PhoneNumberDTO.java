package com.switchfully.order.service.dtos.customer;

import com.switchfully.order.domain.customer.PhoneNumber;

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
}
