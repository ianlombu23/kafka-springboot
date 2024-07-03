package com.woyo.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String customerId;
    private String productId;
    private Integer count;
    private boolean isCheckStock;
    private String paymentMethod;
    private BigDecimal totalAmount;
    private String status;
    private boolean isNeedUpdate;
}
