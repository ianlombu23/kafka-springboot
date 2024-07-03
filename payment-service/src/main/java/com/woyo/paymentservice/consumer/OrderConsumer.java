package com.woyo.paymentservice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woyo.paymentservice.model.Order;
import com.woyo.paymentservice.service.PaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@AllArgsConstructor
public class OrderConsumer {

    private final PaymentService paymentService;

    @KafkaListener(
            topics = {"${spring.kafka.topics.payment}"},
            groupId = "${spring.kafka.group-id}",
            containerFactory = "kafkaListenerCommonFactory"

    )
    public void consume(@Payload Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.convertValue(payload, Order.class);
        log.info("Consume success {} ", order);
        paymentService.execute(order);
    }
}
