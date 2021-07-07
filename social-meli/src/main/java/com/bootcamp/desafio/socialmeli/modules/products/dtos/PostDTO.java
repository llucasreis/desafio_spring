package com.bootcamp.desafio.socialmeli.modules.products.dtos;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.domain.Product;
import com.bootcamp.desafio.socialmeli.shared.utils.DateUtil;

import java.util.List;
import java.util.stream.Collectors;

public class PostDTO {
    private Long id_post;
    private String date;
    private Product detail;
    private String category;
    private double price;

    public PostDTO() {
    }

    public PostDTO(Long id_post, String date, Product detail, String category, double price) {
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
    }

    public static PostDTO convert(Post post) {
        return new PostDTO(
                post.getId_post(),
                DateUtil.getStringDate(post.getDate()),
                post.getDetail(),
                String.valueOf(post.getCategory()),
                post.getPrice()
        );
    }

    public static List<PostDTO> convert(List<Post> posts) {
        return posts.stream().map(PostDTO::convert).collect(Collectors.toList());
    }

    public Long getId_post() {
        return id_post;
    }

    public void setId_post(Long id_post) {
        this.id_post = id_post;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product getDetail() {
        return detail;
    }

    public void setDetail(Product detail) {
        this.detail = detail;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
