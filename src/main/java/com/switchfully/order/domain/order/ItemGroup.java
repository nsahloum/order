package com.switchfully.order.domain.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.service.dtos.order.ItemGroupDTO;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private String itemId;
    private int amount;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate shippingDate;

    public ItemGroup(ItemGroupDTO itemGroupDTO) {
        this.itemId = itemGroupDTO.getItemId();
        this.amount = itemGroupDTO.getAmount();
        this.shippingDate = itemGroupDTO.getShippingDate();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
