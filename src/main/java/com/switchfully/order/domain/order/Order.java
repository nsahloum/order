package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.service.dtos.OrderDTO;

import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<ItemGroup> itemsOrdered;
    private String customerId;

    public Order(List<ItemGroup> itemsOrdered, String customerId) {
        this.id = UUID.randomUUID().toString();
        this.itemsOrdered = itemsOrdered;
        this.customerId = customerId;
    }

    public Order(OrderDTO orderDTO){
        this.id = orderDTO.getId();
        this.itemsOrdered = orderDTO.getItemsOrdered();
        this.customerId = orderDTO.getCustomerId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemGroup> getItemsOrdered() {
        return itemsOrdered;
    }

    public void setOrder(List<ItemGroup> order) {
        this.itemsOrdered = order;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
