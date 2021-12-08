package com.switchfully.order.api;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.service.CustomerService;
import com.switchfully.order.service.OrderService;
import com.switchfully.order.service.dtos.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
public class OrderController {
    private final OrderService orderService;
    private final CustomerService customerService;

    public OrderController(OrderService orderService, CustomerService customerService) {
        this.orderService = orderService;
        this.customerService = customerService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO makeOrder(@RequestBody OrderDTO orderDTO, @RequestHeader String authorization) {
        //TODO add check customer, and find customer by username (make it uniq) and send the ID
        Customer customer = customerService.findCustomerLoggedIn(authorization);
        return orderService.makeOrder(orderDTO, customer.getId());
    }


}
