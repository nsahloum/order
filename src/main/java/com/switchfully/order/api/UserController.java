package com.switchfully.order.api;

import com.switchfully.order.service.UserService;
import com.switchfully.order.service.dtos.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/customers", produces = "application/json")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping (path = "/register", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO registerCustomer(@RequestBody CustomerDTO customerDTO){
        return userService.registerCustomer(customerDTO);
    }

}
