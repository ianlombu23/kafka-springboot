package com.woyo.stockservice.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woyo.stockservice.model.Order;
import com.woyo.stockservice.service.StockService;
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

    private final StockService stockService;

    @KafkaListener(
            topics = {"${spring.kafka.topics.orders}"},
            groupId = "${spring.kafka.group-id}",
            containerFactory = "kafkaListenerCommonFactory"

    )
    public void consume(@Payload Map<String, Object> payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        Order order = objectMapper.convertValue(payload, Order.class);
        log.info("Consume success {} ", order);
        stockService.execute(order);
    }
}
