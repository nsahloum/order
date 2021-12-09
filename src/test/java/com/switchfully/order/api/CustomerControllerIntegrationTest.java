package com.switchfully.order.api;

import com.switchfully.order.service.dtos.customer.AddressDTO;
import com.switchfully.order.service.dtos.customer.CustomerDTO;
import com.switchfully.order.service.dtos.customer.PhoneNumberDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class CustomerControllerIntegrationTest {

    @Autowired
    private CustomerController customerController;

    @Test
    void checkRegisterAsCustomerIsInGetAllCustomers(){
        CustomerDTO customerToAdd = new CustomerDTO("marie","dupont","test@test.com",
                new AddressDTO("test", 2, 2, "bxl"),
                new PhoneNumberDTO("+32", "45213211"), "pass", "user");
        customerController.registerCustomer(customerToAdd);
        List<CustomerDTO> customerDTOList = customerController.getAllCustomers(generateBase64Authorization("user", "password"));
        assertThat(customerDTOList).containsExactly(customerToAdd);
    }

    private String generateBase64Authorization(String username, String password) {
        return "Basic " + Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
    }
}