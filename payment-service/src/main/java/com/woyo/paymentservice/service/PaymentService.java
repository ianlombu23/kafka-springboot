package com.woyo.paymentservice.service;

import com.woyo.paymentservice.model.Order;
import com.woyo.paymentservice.model.PaymentEntity;
import com.woyo.paymentservice.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {

    private final PaymentRepository paymentRepository;


    public void execute(Order order) {
        if (!order.isNeedUpdate()) {
            paymentRepository.save(PaymentEntity.builder()
                    .orderId(order.getId())
                    .customerId(order.getCustomerId())
                    .paymentMethod(order.getPaymentMethod())
                    .build());
            log.info("Success save to payment");
        } else {
            updateDataOrder(order);
        }
    }

    public void updateDataOrder(Order order) {
        PaymentEntity payment = paymentRepository.findByOrderId(order.getId()).orElseThrow();
        payment.setPaymentMethod(order.getPaymentMethod());
        paymentRepository.save(payment);
        log.info("Success update data order");
    }
}
