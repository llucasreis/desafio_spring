package com.bootcamp.desafio.socialmeli.modules.products.dtos;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.domain.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PostPromoFormDTO {
    @NotNull
    private Long userId;

    @NotNull
    private Long id_post;

    @NotNull
    @JsonSerialize(as = Date.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy",
            lenient = OptBoolean.FALSE, locale = "pt-BR", timezone = "America/Sao_Paulo")
    private Date date;

    @NotNull
    private Product detail;

    @NotNull
    @Min(value = 0)
    private int category;

    @NotNull
    @Min(value = 0L)
    private Double price;

    @NotNull
    private boolean hasPromo;

    @NotNull
    @Min(value = 0L)
    private Double discount;

    public PostPromoFormDTO() {
    }

    public PostPromoFormDTO(Long userId, Long id_post, Date date, Product detail, int category, Double price, boolean hasPromo, Double discount) {
        this.userId = userId;
        this.id_post = id_post;
        this.date = date;
        this.detail = detail;
        this.category = category;
        this.price = price;
        this.hasPromo = hasPromo;
        this.discount = discount;
    }

    public Post convert() {
        return new Post(
                this.userId,
                this.id_post,
                this.date,
                this.detail,
                this.category,
                this.price,
                this.hasPromo,
                this.discount
        );
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isHasPromo() {
        return hasPromo;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
}
