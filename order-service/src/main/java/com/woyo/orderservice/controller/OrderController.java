package com.woyo.orderservice.controller;

import com.woyo.orderservice.model.Order;
import com.woyo.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order/v1")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/create")
    private String createOrder(@RequestBody Order order) {
        orderService.execute(order);
        return "Success";
    }

    @PostMapping("/update")
    private String updateOrder(@RequestBody Order order) {
        orderService.updateDataOrder(order);
        return "Update Data Success";
    }

}
