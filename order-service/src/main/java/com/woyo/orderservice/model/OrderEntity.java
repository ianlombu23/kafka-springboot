package com.woyo.orderservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id")
    private String orderId;
    @Column(name="customer_id")
    private String customerId;
    @Column(name="product_id")
    private String productId;
    @Column(name="count")
    private Integer count;
    @Column(name="status")
    private String status;
}
