package com.example.greeting.model;

public class Cart {
    private Integer itemCount;

    private Integer cartPrice;

    public Cart(Integer itemCount, Integer cartPrice) {
        this.itemCount = itemCount;
        this.cartPrice = cartPrice;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public Integer getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Integer cartPrice) {
        this.cartPrice = cartPrice;
    }
}
