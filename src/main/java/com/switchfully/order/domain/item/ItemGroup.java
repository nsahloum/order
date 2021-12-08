package com.switchfully.order.domain.item;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private String itemId;
    private int amount;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate shippingDate;

    public ItemGroup(String itemId, int amount) {
        this.id = UUID.randomUUID().toString();
        this.itemId = itemId;
        this.amount = amount;
    }

    public String getId() {
        return id;
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
