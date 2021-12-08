package com.switchfully.order.domain.order;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.service.dtos.OrderDTO;

import java.util.List;
import java.util.UUID;

public class Order {
    private String id;
    private List<ItemGroup> itemGroups;
    private String customerId;

    public Order(List<ItemGroup> itemGroups, String customerId) {
        this.id = UUID.randomUUID().toString();
        this.itemGroups = itemGroups;
        this.customerId = customerId;
    }

    public Order(OrderDTO orderDTO){
        this.id = orderDTO.getId();
        this.itemGroups = orderDTO.getItemsGroups();
        this.customerId = orderDTO.getCustomerId();
    }

    public String getId() {
        return id;
    }

    public List<ItemGroup> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(List<ItemGroup> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
