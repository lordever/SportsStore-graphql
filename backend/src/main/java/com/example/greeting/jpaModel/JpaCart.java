package com.example.greeting.jpaModel;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class JpaCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(value = ViewUtil.Public.class)
    private Integer id;

    private Integer itemCount;

    private Integer cartPrice;

    public JpaCart() {
    }

    public JpaCart(JpaCartLine line, Integer itemCount, Integer cartPrice) {
        this.itemCount = itemCount;
        this.cartPrice = cartPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
