package com.switchfully.order.domain.item;

import com.switchfully.order.service.dtos.ItemDTO;

import java.util.UUID;

public class Item {
    private final String id;
    private String name;
    private String description;
    private double price;
    private int stock;

    public Item(String name, String description, double price, int stock) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    public Item(ItemDTO itemDTO) {
        this.id = itemDTO.getId();
        this.name = itemDTO.getName();
        this.description = itemDTO.getDescription();
        this.price = itemDTO.getPrice();
        this.stock = itemDTO.getStock();
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
}
