package com.sparta.msaexam.order.dto;

import com.sparta.msaexam.order.entity.Order;
import com.sparta.msaexam.order.entity.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDto {

    private Long orderId;

    private String name;

    private List<OrderProduct> productList;

    public OrderResponseDto(Order order, List<OrderProduct> productList) {
        this.orderId = order.getOrderId();
        this.name = order.getName();
        this.productList = productList;
    }

    public OrderResponseDto(Order order) {
        this.orderId = order.getOrderId();
        this.name = order.getName();
    }
}
