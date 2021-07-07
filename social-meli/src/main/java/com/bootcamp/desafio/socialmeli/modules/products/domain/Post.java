package com.bootcamp.desafio.socialmeli.modules.products.domain;

import java.util.Date;

public class Post {
    private Long userId;
    private Long id_post;
    private Date date;
    private Product detail;
    private int category;
    private double price;

    public Post() {
    }

    public Post(Long userId, Long id_post, Date date, Product detail, int category, double price) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Post{" +
                "userId=" + userId +
                ", id_post=" + id_post +
                ", date=" + date +
                ", detail=" + detail +
                '}';
    }
}
