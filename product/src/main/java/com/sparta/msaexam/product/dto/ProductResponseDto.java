package com.sparta.msaexam.product.dto;

import com.sparta.msaexam.product.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {

    private Long productId;
    private String name;
    private int suppyPrice;

    public ProductResponseDto(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.suppyPrice = product.getSupplyPrice();
    }
}
