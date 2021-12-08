package com.switchfully.order.service.dtos.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.domain.order.ItemGroup;

import java.time.LocalDate;

public class ItemGroupDTO {
    private String itemId;
    private int amount;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate shippingDate;

    public ItemGroupDTO(String itemId, int amount) {
        this.itemId = itemId;
        this.amount = amount;
    }
    
    public ItemGroupDTO(ItemGroup itemGroup){
        this.itemId = itemGroup.getItemId();
        this.amount = itemGroup.getAmount();
        this.shippingDate = itemGroup.getShippingDate();
    }

    public ItemGroupDTO(ItemGroupDTO itemGroupDTO) {
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
