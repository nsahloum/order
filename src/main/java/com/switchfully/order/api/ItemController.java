package com.switchfully.order.api;

import com.switchfully.order.service.ItemService;
import com.switchfully.order.service.SecurityService;
import com.switchfully.order.service.dtos.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items", produces = "application/json")
public class ItemController {
    private final ItemService itemService;
    private final SecurityService securityService;

    public ItemController(ItemService itemService, SecurityService securityService) {
        this.itemService = itemService;
        this.securityService = securityService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestHeader String authorization, @RequestBody ItemDTO itemDTO) {
        securityService.checkIfAdmin(authorization);
        return itemService.addItem(itemDTO);
    }

}
