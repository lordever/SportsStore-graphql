package com.example.greeting.jpaModel;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;

@Entity
@Table(name="product")
public class JpaProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonView(value = ViewUtil.Public.class)
    private Integer id;

    private String name;

    private String category;

    private String description;

    private Integer price;

    public JpaProduct() {
    }

    public JpaProduct(String name, String category, String description, Integer price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
