package com.example.inventoryservice.service;

import com.example.inventoryservice.model.InventoryItem;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InventoryService {

    private final Map<String, InventoryItem> inventoryMap = new HashMap<>();

    public InventoryService() {
        inventoryMap.put("부품A", new InventoryItem("부품A", 5));
        inventoryMap.put("부품B", new InventoryItem("부품B", 0));
    }

    public InventoryItem getInventoryByItemName(String itemName) {
        return inventoryMap.getOrDefault(itemName, new InventoryItem(itemName, 0));
    }
}
