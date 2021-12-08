package com.switchfully.order.service.mappers;

import com.switchfully.order.domain.order.Order;
import com.switchfully.order.service.dtos.order.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {
    public OrderDTO mapToDTO(Order order) {
        return new OrderDTO(order);
    }

    public Order mapToOrder(OrderDTO orderDTO) {
        return new Order(orderDTO);
    }

    public List<OrderDTO> convertOrderMapToDtoList(List<Order> orders) {
        return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
    }
}
