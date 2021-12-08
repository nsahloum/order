package com.switchfully.order.repository;

import com.switchfully.order.domain.order.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class OrderRepository {
    private HashMap<String, Order> orders = new HashMap<>();


    public Order makeOrder(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public Order getOrderOfCustomer(String customerId) {
        return orders.get(customerId);
    }
}
