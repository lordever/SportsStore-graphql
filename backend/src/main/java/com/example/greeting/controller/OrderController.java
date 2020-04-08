package com.example.greeting.controller;

import com.example.greeting.jpaModel.JpaSalesOrder;
import com.example.greeting.model.SalesOrder;
import com.example.greeting.repository.CartRepository;
import com.example.greeting.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public Iterable<JpaSalesOrder> orders() {
        return orderRepository.findAll();
    }

    @PostMapping
    public HttpStatus save(@RequestBody SalesOrder order) {
        this.saveSalesOrder(order);
        cartRepository.save(order.getCart());
        return HttpStatus.OK;
    }

    private void saveSalesOrder(SalesOrder order){
        JpaSalesOrder jpaSalesOrder = new JpaSalesOrder(
                order.getSnippet(),
                order.getName(),
                order.getAddress(),
                order.getCity(),
                order.getState(),
                order.getZip(),
                order.getCountry(),
                order.getCart()
        );
        orderRepository.save(jpaSalesOrder);
    }
}
