package com.example.greeting.controller;

import com.example.greeting.jpaModel.JpaCart;
import com.example.greeting.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartRepository cartRepository;

    @GetMapping
    public JpaCart get() {
        return this.getNewCart();
    }

    @GetMapping("/{id}")
    public JpaCart getById(@PathVariable Integer id) {
        Iterable<JpaCart> carts = this.cartRepository.findAll();
        JpaCart foundCart = new JpaCart();
        for (JpaCart cart : carts) {
            if (Objects.equals(cart.getId(), id)) {
                foundCart = cart;
            }
        }
        if (foundCart.getId() == null) {
            foundCart = null;
        }
        return foundCart;
    }

    private JpaCart getNewCart() {
        JpaCart newCart = new JpaCart();
        return cartRepository.save(newCart);
    }
}
