package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.InventoryItem;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/test")
    public String test() {
        return "Inventory service is running!";
    }

    @GetMapping("/{itemName}")
    public InventoryItem getInventory(@PathVariable String itemName) {
        return inventoryService.getInventoryByItemName(itemName);
    }
}
