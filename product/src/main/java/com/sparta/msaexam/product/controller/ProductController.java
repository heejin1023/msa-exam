package com.sparta.msaexam.product.controller;

import com.sparta.msaexam.product.dto.ProductRequestDto;
import com.sparta.msaexam.product.dto.ProductResponseDto;
import com.sparta.msaexam.product.entity.Product;
import com.sparta.msaexam.product.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/products/test")
    public String getProduct() {
        return "Product info from port : " + serverPort;
    }

    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto productRequestDto){
        return productService.createProduct(productRequestDto);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public ProductResponseDto getProduct(@PathVariable("id") Long id){
        return productService.getProductById(id);
    }

}
