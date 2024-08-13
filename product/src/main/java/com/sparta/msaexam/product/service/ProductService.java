package com.sparta.msaexam.product.service;

import com.sparta.msaexam.product.dto.ProductRequestDto;
import com.sparta.msaexam.product.dto.ProductResponseDto;
import com.sparta.msaexam.product.entity.Product;
import com.sparta.msaexam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResponseDto createProduct(ProductRequestDto productRequestDto) {
        Product product = productRepository.save(new Product(productRequestDto));
        return new ProductResponseDto(product);
    }

    public List<Product> getAllProducts() {

        return productRepository.findAll();
    }

    public ProductResponseDto getProductById(Long productId) {
        return new ProductResponseDto(productRepository.findById(productId).get());
    }

 }
