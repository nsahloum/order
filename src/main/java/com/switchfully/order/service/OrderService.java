package com.switchfully.order.service;

import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.service.dtos.OrderDTO;
import com.switchfully.order.service.mappers.OrderMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderMapper orderMapper;
    private OrderRepository orderRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
    }

    public OrderDTO makeOrder(OrderDTO orderDTO, String customerId) {
        return orderMapper.mapToDTO(orderRepository.makeOrder(orderMapper.mapToOrder(orderDTO), customerId));
    }
}
