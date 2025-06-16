package com.example.inventoryservice.model;

public class InventoryItem {
    private String itemName;
    private int quantity;

    public InventoryItem() {}
    public InventoryItem(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() { return itemName; }
    public int getQuantity() { return quantity; }

    public void setItemName(String itemName) { this.itemName = itemName; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
