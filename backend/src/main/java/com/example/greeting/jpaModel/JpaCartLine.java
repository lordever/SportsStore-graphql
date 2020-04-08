package com.example.greeting.jpaModel;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name = "cartLine")
public class JpaCartLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(value = ViewUtil.Public.class)
    private Integer id;

    private Integer lineTotal;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private JpaProduct product;

    private Integer quantity;

    public JpaCartLine() {
    }

    public JpaCartLine(Integer lineTotal, JpaProduct product, Integer quantity) {
        this.lineTotal = lineTotal;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(Integer lineTotal) {
        this.lineTotal = lineTotal;
    }

    public JpaProduct getProduct() {
        return product;
    }

    public void setProduct(JpaProduct product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
