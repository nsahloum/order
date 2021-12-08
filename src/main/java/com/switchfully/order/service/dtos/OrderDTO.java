package com.switchfully.order.service.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.domain.item.ItemGroup;
import com.switchfully.order.domain.order.Order;

import java.util.List;
import java.util.UUID;

public class OrderDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private List<ItemGroup> itemsGroups;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String customerId;

    public OrderDTO(List<ItemGroup> itemsGroups, String customerId) {
        this.id = UUID.randomUUID().toString();
        this.itemsGroups = itemsGroups;
        this.customerId = customerId;
    }

    public OrderDTO(Order order){
        this.id = order.getId();
        this.itemsGroups = order.getItemGroups();
        this.customerId = order.getCustomerId();
    }

    public List<ItemGroup> getItemsGroups() {
        return itemsGroups;
    }

    public String getId() {
        return id;
    }

    public void setItemsGroups(List<ItemGroup> itemsGroups) {
        this.itemsGroups = itemsGroups;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
