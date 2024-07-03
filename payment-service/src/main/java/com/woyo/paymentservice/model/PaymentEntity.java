package com.woyo.paymentservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class PaymentEntity {
    @Id
    @UuidGenerator
    @Column(name="payment_id")
    private String paymentId;

    @Column(name="order_id")
    private String orderId;

    @Column(name="customer_id")
    private String customerId;

    @Column(name = "payment_method")
    private String paymentMethod;

}
