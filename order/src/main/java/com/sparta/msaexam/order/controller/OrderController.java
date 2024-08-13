package com.sparta.msaexam.order.controller;

import com.sparta.msaexam.order.client.ProductClient;
import com.sparta.msaexam.order.dto.OrderRequestDto;
import com.sparta.msaexam.order.dto.OrderResponseDto;
import com.sparta.msaexam.order.dto.ProductDto;
import com.sparta.msaexam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/order")
    public OrderResponseDto createOrder(@RequestBody OrderRequestDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @PutMapping("/order/{id}")
    public OrderResponseDto updateOrder(@PathVariable("id") long orderId, @RequestBody OrderRequestDto orderDto) {
        return orderService.addOrderProduct(orderId, orderDto);
    }

    @GetMapping("/order/{id}")
    public OrderResponseDto getOrderById(@PathVariable("id") long orderId) {
        return orderService.getOrder(orderId);
    }
}
