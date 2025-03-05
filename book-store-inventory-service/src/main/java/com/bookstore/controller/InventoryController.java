package com.bookstore.controller;

import com.bookstore.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/update")
    public ResponseEntity<Void> updateInventory(@RequestBody List<Long> bookIds) {
        logger.info("Received request to update inventory for books: {}", bookIds);
        inventoryService.updateInventory(bookIds);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add/{bookId}/{stockQuantity}")
    public ResponseEntity<Void> addInventory(@PathVariable Long bookId, @PathVariable Integer stockQuantity) {
        logger.info("Received request to add inventory for book ID: {} with quantity: {}", bookId, stockQuantity);
        inventoryService.addInventory(bookId, stockQuantity);
        return ResponseEntity.ok().build();
    }
}