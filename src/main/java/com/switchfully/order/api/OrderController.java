package com.switchfully.order.api;

import com.switchfully.order.service.CustomerService;
import com.switchfully.order.service.OrderService;
import com.switchfully.order.service.dtos.customer.CustomerDTO;
import com.switchfully.order.service.dtos.order.OrderDTO;
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
        CustomerDTO customerLoggedIn = customerService.findCustomerLoggedIn(authorization);
        return orderService.makeOrder(orderDTO, customerLoggedIn.getId());
    }

    @GetMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO getOrderOfCustomerLoggedIn(@RequestHeader String authorization){
        CustomerDTO customerLoggedIn =  customerService.findCustomerLoggedIn(authorization);
        return orderService.getOrderOfCustomer(customerLoggedIn.getId());
    }


}
