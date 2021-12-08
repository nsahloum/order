package com.switchfully.order.service;

import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.service.dtos.OrderDTO;
import com.switchfully.order.service.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final ItemService itemService;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, ItemService itemService) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.itemService = itemService;
    }

    public OrderDTO makeOrder(OrderDTO orderDTO, String customerId) {
        orderDTO.getItemsGroups().forEach(itemGroup -> {
            if (itemService.getItemById(itemGroup.getItemId()).getStock() >= itemGroup.getAmount()){
                itemGroup.setShippingDate(LocalDate.now().plusDays(1));
            }
            else{
                itemGroup.setShippingDate(LocalDate.now().plusDays(7));
            }
        });
        orderDTO.setCustomerId(customerId);
        return orderMapper.mapToDTO(orderRepository.makeOrder(orderMapper.mapToOrder(orderDTO)));
    }

    public OrderDTO getOrderOfCustomer(String customerId) {
        return orderMapper.mapToDTO(orderRepository.getOrderOfCustomer(customerId));
    }

}
