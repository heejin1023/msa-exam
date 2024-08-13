package com.sparta.msaexam.product.repository;

import com.sparta.msaexam.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
