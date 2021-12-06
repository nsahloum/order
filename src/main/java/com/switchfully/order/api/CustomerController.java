package com.switchfully.order.api;

import com.switchfully.order.service.SecurityService;
import com.switchfully.order.service.CustomerService;
import com.switchfully.order.service.dtos.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/customers", produces = "application/json")
public class CustomerController {
    private final CustomerService customerService;
    private final SecurityService securityService;

    public CustomerController(CustomerService customerService, SecurityService securityService) {
        this.customerService = customerService;
        this.securityService = securityService;
    }

    @PostMapping (consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO registerCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.registerCustomerDTO(customerDTO);
    }

    @GetMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDTO> getAllCustomer(@RequestHeader String authorization) {
        securityService.checkIfAdmin(authorization);
        return customerService.getAllCustomerDTO();
    }

}
