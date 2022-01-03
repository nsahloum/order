package com.switchfully.order.domain.order;

import com.switchfully.order.service.dtos.order.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

public class Order {
    private final String id;
    private List<ItemGroup> itemGroups;
    private int customerId;

    public Order(OrderDTO orderDTO) {
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

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
