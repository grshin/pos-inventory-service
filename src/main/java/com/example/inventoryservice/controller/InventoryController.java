package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.InventoryItem;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "재고 API", description = "재고 조회 기능 제공")
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @Operation(summary = "테스트 API", description = "Inventory 서비스가 정상 작동하는지 확인합니다.")
    @GetMapping("/test")
    public String test() {
        return "Inventory service is running!";
    }

    @Operation(summary = "재고 단건 조회", description = "아이템 이름으로 해당 재고 정보를 조회합니다.")
    @GetMapping("/{itemName}")
    public InventoryItem getInventory(
        @Parameter(description = "조회할 아이템 이름", example = "item-123")
        @PathVariable String itemName
    ) {
        return inventoryService.getInventoryByItemName(itemName);
    }
}
