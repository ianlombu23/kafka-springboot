package com.woyo.orderservice.service;

import com.woyo.orderservice.model.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PublishToKafka {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${spring.kafka.topics.orders}")
    private String orderTopic;

    @Value("${spring.kafka.topics.payment}")
    private String paymentTopic;

    public void publishStockProduct(Order order) {
        log.info("Send to stock, {} ", order);
        kafkaTemplate.send(orderTopic, order);
    }

    public void publishPayment(Order order) {
        log.info("Send to payment , {} ", order);
        kafkaTemplate.send(paymentTopic, order);
    }
}
