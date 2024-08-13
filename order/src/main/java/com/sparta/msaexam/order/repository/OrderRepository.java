package com.sparta.msaexam.order.repository;

import com.sparta.msaexam.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}