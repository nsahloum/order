package com.switchfully.order.api;

import com.switchfully.order.service.OrderService;
import com.switchfully.order.service.SecurityService;
import com.switchfully.order.service.dtos.OrderDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/order", produces = "application/json")
public class OrderController {
    private OrderService orderService;
    private SecurityService securityService;

    public OrderController(OrderService orderService, SecurityService securityService) {
        this.orderService = orderService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO makeOrder(@RequestBody OrderDTO orderDTO, @RequestHeader String authorization){
        //TODO add check customer, and find customer by username (make it uniq) and send the ID
        return orderService.makeOrder(orderDTO);
    }


}
