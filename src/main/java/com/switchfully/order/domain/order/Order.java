package com.switchfully.order.domain.order;

import com.switchfully.order.service.dtos.order.ItemGroupDTO;
import com.switchfully.order.service.dtos.order.OrderDTO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Order {
    private final String id;
    private List<ItemGroup> itemGroups;
    private String customerId;

    public Order(List<ItemGroup> itemGroups, String customerId) {
        this.id = UUID.randomUUID().toString();
        this.itemGroups = itemGroups;
        this.customerId = customerId;
    }

    public Order(OrderDTO orderDTO){
        this.id = orderDTO.getId();
        this.itemGroups = orderDTO.getItemsGroups().stream().map(ItemGroup::new).collect(Collectors.toList());
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
