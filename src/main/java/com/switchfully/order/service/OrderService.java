package com.switchfully.order.service;

import com.switchfully.order.repository.OrderRepository;
import com.switchfully.order.service.dtos.order.OrderDTO;
import com.switchfully.order.service.mappers.OrderMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

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

    public OrderDTO makeOrder(OrderDTO orderDTO, int customerId) {
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

    public List<OrderDTO> getOrderOfCustomer(int customerId) {
        return orderMapper.convertOrderMapToDtoList(orderRepository.getOrderOfCustomer(customerId));
    }

}
