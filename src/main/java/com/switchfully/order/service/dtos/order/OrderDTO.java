package com.switchfully.order.service.dtos.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.switchfully.order.domain.order.ItemGroup;
import com.switchfully.order.domain.order.Order;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;
    private List<ItemGroupDTO> itemsGroups;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int customerId;

    public OrderDTO(List<ItemGroupDTO> itemsGroups, int customerId) {
        this.id = UUID.randomUUID().toString();
        this.itemsGroups = itemsGroups;
        this.customerId = customerId;
    }

    public OrderDTO(Order order){
        this.id = order.getId();
        this.itemsGroups = order.getItemGroups().stream().map(ItemGroupDTO::new).collect(Collectors.toList());
        this.customerId = order.getCustomerId();
    }

    public List<ItemGroupDTO> getItemsGroups() {
        return itemsGroups;
    }

    public String getId() {
        return id;
    }

    public void setItemsGroups(List<ItemGroupDTO> itemsGroups) {
        this.itemsGroups = itemsGroups;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
