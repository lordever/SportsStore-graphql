package com.example.greeting.model;

import com.example.greeting.jpaModel.JpaCart;

public class SalesOrder {
    private Boolean snippet;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;
    private JpaCart cart;

    public SalesOrder(Boolean snippet, String name, String address, String city, String state, String zip, String country, JpaCart cart) {
        this.snippet = snippet;
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.country = country;
        this.cart = cart;
    }

    public Boolean getSnippet() {
        return snippet;
    }

    public void setSnippet(Boolean snippet) {
        this.snippet = snippet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public JpaCart getCart() {
        return cart;
    }

    public void setCart(JpaCart cart) {
        this.cart = cart;
    }
}
