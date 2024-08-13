package com.sparta.msaexam.order.service;

import com.sparta.msaexam.order.entity.OrderProduct;
import com.sparta.msaexam.order.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProduct save(OrderProduct orderProduct) {
        return orderProductRepository.save(orderProduct);
    }

    public List<OrderProduct> findByOrderId(Long orderId) {
        return orderProductRepository.findByOrder_orderId(orderId);
    }
}
