package com.switchfully.order.service.dtos;

import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;

import java.util.List;
import java.util.UUID;

public class OrderDTO {
    private String id;
    private List<ItemGroup> itemsOrder;
    private String customerId;

    public OrderDTO(List<ItemGroup> itemsOrder, String customerId) {
        this.id = UUID.randomUUID().toString();
        this.itemsOrder = itemsOrder;
        this.customerId = customerId;
    }

    public OrderDTO(Order order){
        this.id = order.getId();
        this.itemsOrder = order.getItemsOrdered();
        this.customerId = order.getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ItemGroup> getItemsOrdered() {
        return itemsOrder;
    }

    public void setOrder(List<ItemGroup> order) {
        this.itemsOrder = order;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
