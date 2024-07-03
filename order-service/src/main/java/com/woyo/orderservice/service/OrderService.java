package com.woyo.orderservice.service;

import com.woyo.orderservice.model.Order;
import com.woyo.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderService {

    private final PublishToKafka publishToKafka;
    private final OrderRepository orderRepository;

    public void execute(Order order) {
        publishToKafka.publishStockProduct(order);
        publishToKafka.publishPayment(order);
    }

    public void updateDataOrder(Order order) {
        order.setNeedUpdate(true);
        publishToKafka.publishPayment(order);
    }
}
