package com.sparta.msaexam.order.dto;

import com.sparta.msaexam.order.entity.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDto {

    private Long orderId;
    private String name;
    private List<OrderProduct> productList;
}
