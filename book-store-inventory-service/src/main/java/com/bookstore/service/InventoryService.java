package com.bookstore.service;

import com.bookstore.entity.Inventory;
import com.bookstore.repo.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private static final Logger logger = LoggerFactory.getLogger(InventoryService.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    public void updateInventory(List<Long> bookIds) {
        for (Long bookId : bookIds) {
            Inventory inventory = inventoryRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Inventory not found for book ID: " + bookId));
            if (inventory.getStockQuantity() <= 0) {
                logger.warn("Stock quantity is zero for book ID: {}", bookId);
                throw new RuntimeException("Stock quantity is zero for book ID: " + bookId);
            }
            inventory.setStockQuantity(inventory.getStockQuantity() - 1);
            inventoryRepository.save(inventory);
            logger.info("Updated inventory for book ID: {}", bookId);
        }
    }

    public void addInventory(Long bookId, Integer stockQuantity) {
        Inventory inventory = new Inventory();
        inventory.setBookId(bookId);
        inventory.setStockQuantity(stockQuantity);
        inventoryRepository.save(inventory);
        logger.info("Added inventory for book ID: {}", bookId);
    }
}