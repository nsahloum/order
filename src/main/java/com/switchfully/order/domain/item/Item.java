package com.switchfully.order.domain.item;

import com.switchfully.order.service.dtos.item.ItemDTO;

import java.util.UUID;

public class Item {
    private final String id;
    private String name;
    private String description;
    private double price;
    private int stock;
    private ItemUrgencyIndicator itemUrgencyIndicator;

    public Item(ItemDTO itemDTO) {
        this.id = itemDTO.getId();
        this.name = itemDTO.getName();
        this.description = itemDTO.getDescription();
        this.price = itemDTO.getPrice();
        this.stock = itemDTO.getStock();
        this.itemUrgencyIndicator = itemDTO.getItemUrgencyIndicator();
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

    public void setItemUrgencyIndicator(ItemUrgencyIndicator itemUrgencyIndicator) {
        this.itemUrgencyIndicator = itemUrgencyIndicator;
    }
}
