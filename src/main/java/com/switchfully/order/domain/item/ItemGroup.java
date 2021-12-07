package com.switchfully.order.domain.item;

import java.time.LocalDate;
import java.util.UUID;

public class ItemGroup {
    private final String id;
    private Item item;
    private int amount;
    private LocalDate shippingDate;

    public ItemGroup(Item item, int amount) {
        this.id = UUID.randomUUID().toString();
        this.item = item;
        this.amount = amount;
        if (amount <= item.getStock()){
            this.shippingDate = LocalDate.now().plusDays(1);
        }
        else{
            this.shippingDate = LocalDate.now().plusDays(7);
        }
    }

    public String getId() {
        return id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
