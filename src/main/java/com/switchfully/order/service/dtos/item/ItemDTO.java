package com.switchfully.order.service.dtos.item;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.domain.item.ItemUrgencyIndicator;

import java.util.UUID;

public class ItemDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final String id;
    private String name;
    private String description;
    private double price;
    private int stock;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private ItemUrgencyIndicator itemUrgencyIndicator;

    public ItemDTO(String name, String description, double price, int stock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.setItemUrgencyIndicator();
    }

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.description = item.getDescription();
        this.price = item.getPrice();
        this.stock = item.getStock();
        this.itemUrgencyIndicator = item.getItemUrgencyIndicator();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public ItemUrgencyIndicator getItemUrgencyIndicator() {
        return itemUrgencyIndicator;
    }

    public void setItemUrgencyIndicator() {
        if (stock < 5){
            itemUrgencyIndicator = ItemUrgencyIndicator.STOCK_LOW;
        }
        else if (stock < 10){
            itemUrgencyIndicator = ItemUrgencyIndicator.STOCK_MEDIUM;
        }
        else {
            itemUrgencyIndicator = ItemUrgencyIndicator.STOCK_HIGH;
        }
    }
}
