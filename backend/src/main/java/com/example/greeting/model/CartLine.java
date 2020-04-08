package com.example.greeting.model;

public class CartLine {
    private Integer lineTotal;

    private Product product;

    private Integer quantity;

    public CartLine(Integer lineTotal, Product product, Integer quantity) {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
