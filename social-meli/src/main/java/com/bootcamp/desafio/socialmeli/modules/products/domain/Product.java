package com.bootcamp.desafio.socialmeli.modules.products.domain;

public class Product {
    private Long product_id;
    private String productName;
    private String brand;
    private String color;
    private String notes;

    public Product() {
    }

    public Product(Long product_id, String productName, String brand, String color, String notes) {
        this.product_id = product_id;
        this.productName = productName;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public Long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", productName='" + productName + '\'' +
                '}';
    }
}
