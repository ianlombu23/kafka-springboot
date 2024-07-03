package com.woyo.stockservice.service;

import com.woyo.stockservice.model.Order;
import com.woyo.stockservice.model.ProductEntity;
import com.woyo.stockservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class StockService {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ProductRepository productRepository;

    @Value("${spring.kafka.topics.stockOrder}")
    private String topic;

    public void execute(Order order) {
        ProductEntity product = productRepository.findById(order.getProductId()).orElseThrow();
        product.setAvailableStock(product.getAvailableStock() - order.getCount());
        productRepository.save(product);
    }
}
