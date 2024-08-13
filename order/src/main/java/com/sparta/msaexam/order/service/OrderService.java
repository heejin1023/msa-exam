package com.sparta.msaexam.order.service;

import com.sparta.msaexam.order.client.ProductClient;
import com.sparta.msaexam.order.dto.OrderRequestDto;
import com.sparta.msaexam.order.dto.OrderResponseDto;
import com.sparta.msaexam.order.dto.ProductDto;
import com.sparta.msaexam.order.entity.Order;
import com.sparta.msaexam.order.entity.OrderProduct;
import com.sparta.msaexam.order.repository.OrderProductRepository;
import com.sparta.msaexam.order.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final OrderProductRepository orderProductRepository;

    private final ProductClient productClient;
    private final OrderProductService orderProductService;


    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        List<OrderProduct> productList = orderRequestDto.getProductList();

        Order order = orderRepository.save(new Order(orderRequestDto));

        List<OrderProduct> newProductList = new ArrayList<>();
        for(OrderProduct orderProduct : productList){
            Long productId = orderProduct.getProductId();
            ProductDto product = productClient.getProduct(productId);

            if(product != null){
                orderProduct.setOrder(order);
                OrderProduct newOrderProduct = orderProductService.save(orderProduct);
                newProductList.add(newOrderProduct);
            }
        }

        return new OrderResponseDto(order, newProductList);

    }

    public OrderResponseDto addOrderProduct(Long orderId, OrderRequestDto orderDto) {
        Order order = orderRepository.findById(orderId).get();

        if(order == null){
            return null;
        }

        List<OrderProduct> productList = orderDto.getProductList();
        List<OrderProduct> newProductList = new ArrayList<>();

        for(OrderProduct orderProduct : productList){
            Long productId = orderProduct.getProductId();
            ProductDto product = productClient.getProduct(productId);

            if(product != null){
                orderProduct.setOrder(order);
                OrderProduct newOrderProduct = orderProductService.save(orderProduct);
                newProductList.add(newOrderProduct);
            }
        }
        return new OrderResponseDto(order, newProductList);
    }

    public OrderResponseDto getOrder(Long orderId) {

        Order order = orderRepository.findById(orderId).get();
        List<OrderProduct> orderProductList = orderProductService.findByOrderId(orderId);
        return new OrderResponseDto(order, orderProductList);
    }
}
