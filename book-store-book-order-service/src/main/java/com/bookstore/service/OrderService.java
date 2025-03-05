package com.bookstore.service;

import com.bookstore.entity.Order;
import com.bookstore.repo.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Service
public class OrderService {
    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @CircuitBreaker(name = "orderService", fallbackMethod = "getAllOrdersFallback")
    public List<Order> getAllOrders() {
        logger.info("Fetching all orders");
        return orderRepository.findAll();
    }

    @CircuitBreaker(name = "orderService", fallbackMethod = "getOrderByIdFallback")
    public Order getOrderById(Long id) {
        logger.info("Fetching order with ID: {}", id);
        return orderRepository.findById(id).orElse(null);
    }

    @CircuitBreaker(name = "orderService", fallbackMethod = "createOrderFallback")
    public Order createOrder(Order order) {
        logger.info("Creating order for customer: {}", order.getCustomerEmail());
        Order savedOrder = orderRepository.save(order);
        // Update inventory
        updateInventory(savedOrder.getBookIds());
        return savedOrder;
    }

    private void updateInventory(List<Long> bookIds) {
        webClientBuilder.build()
            .post()
            .uri("http://inventory-service/inventory/update")
            .bodyValue(bookIds)
            .retrieve()
            .bodyToMono(Void.class)
            .subscribe(
                result -> logger.info("Inventory updated for books: {}", bookIds),
                error -> logger.error("Failed to update inventory for books: {}", bookIds, error)
            );
    }

    // Fallback methods
    public List<Order> getAllOrdersFallback(Throwable t) {
        logger.error("Circuit breaker triggered for getAllOrders: {}", t.getMessage());
        return Collections.emptyList();
    }

    public Order getOrderByIdFallback(Long id, Throwable t) {
        logger.error("Circuit breaker triggered for getOrderById: {}", t.getMessage());
        return null;
    }

    public Order createOrderFallback(Order order, Throwable t) {
        logger.error("Circuit breaker triggered for createOrder: {}", t.getMessage());
        return null;
    }
}