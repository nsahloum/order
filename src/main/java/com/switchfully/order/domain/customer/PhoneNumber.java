package com.switchfully.order.domain.customer;

import com.switchfully.order.service.dtos.customer.PhoneNumberDTO;

import javax.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {
    @Id
    @GeneratedValue(generator = "phone_number_seq")
    private int id;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "number")
    private String number;

    public PhoneNumber() {
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
