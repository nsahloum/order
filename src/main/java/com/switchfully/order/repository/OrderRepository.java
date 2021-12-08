package com.switchfully.order.repository;

import com.switchfully.order.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private HashMap<String, Order> orders = new HashMap<>();


    public Order makeOrder(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public List<Order> getOrderOfCustomer(String customerId) {
        return orders.values().stream().filter(order -> order.getCustomerId().equals(customerId)).collect(Collectors.toList());
    }
}
