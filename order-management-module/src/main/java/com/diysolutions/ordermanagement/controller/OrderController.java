package com.diysolutions.ordermanagement.controller;

import com.diysolutions.entity.ordermanagement.Order;
 import com.diysolutions.ordermanagement.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody @Valid Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    @GetMapping("/{trackingNumber}")
    public ResponseEntity<Order> getOrder(@PathVariable String trackingNumber) {
        return orderService.getOrderByTrackingNumber(trackingNumber)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}

