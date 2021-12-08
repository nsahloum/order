package com.switchfully.order.api;

import com.switchfully.order.service.ItemService;
import com.switchfully.order.service.AdminService;
import com.switchfully.order.service.dtos.ItemDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/items", produces = "application/json")
public class ItemController {
    private final ItemService itemService;
    private final AdminService adminService;

    public ItemController(ItemService itemService, AdminService adminService) {
        this.itemService = itemService;
        this.adminService = adminService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ItemDTO addItem(@RequestHeader String authorization, @RequestBody ItemDTO itemDTO) {
        adminService.checkIfAdmin(authorization);
        return itemService.addItem(itemDTO);
    }

}
