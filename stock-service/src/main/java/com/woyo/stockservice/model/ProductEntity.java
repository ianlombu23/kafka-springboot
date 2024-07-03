package com.woyo.stockservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {

    @Id
    @UuidGenerator
    @Column(name="product_id")
    private String productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "available_stock")
    private Integer availableStock;

    @Column(name = "amount")
    private BigDecimal amount;
}
