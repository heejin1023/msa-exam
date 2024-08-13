package com.sparta.msaexam.product.entity;

import com.netflix.discovery.converters.Auto;
import com.sparta.msaexam.product.dto.ProductRequestDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Entity
@Getter
@Table(name = "product")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int supplyPrice;

    public Product(ProductRequestDto requestDto) {
        this.name = requestDto.getName();
        this.supplyPrice = requestDto.getSupplyPrice();
    }
}
