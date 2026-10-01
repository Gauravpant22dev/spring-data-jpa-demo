package com.example.SpringDataJpa.controller;

import com.example.SpringDataJpa.dto.CreateOrderDto;
import com.example.SpringDataJpa.dto.CreateUserdto;
import com.example.SpringDataJpa.dto.OrderDto;
import com.example.SpringDataJpa.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/users/{userId}/orders")
@AllArgsConstructor
@RestController

public class OrderController {
    private final OrderService orderService;
    @PostMapping
    public ResponseEntity<OrderDto>createOrder(@PathVariable Long userId, @RequestBody CreateOrderDto createOrderDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(userId,createOrderDto));
    }

}
