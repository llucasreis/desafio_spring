package com.bootcamp.desafio.socialmeli.modules.products.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;

public class SellerPromoPostCountDTO {
    private Long userId;
    private String userName;
    private int promoproducts_count;

    public SellerPromoPostCountDTO() {
    }

    public SellerPromoPostCountDTO(Long userId, String userName, int promoproducts_count) {
        this.userId = userId;
        this.userName = userName;
        this.promoproducts_count = promoproducts_count;
    }

    public static SellerPromoPostCountDTO convert(Seller seller, int promoproducts_count) {
        return new SellerPromoPostCountDTO(
                seller.getUserId(),
                seller.getUserName(),
                promoproducts_count
        );
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPromoproducts_count() {
        return promoproducts_count;
    }

    public void setPromoproducts_count(int promoproducts_count) {
        this.promoproducts_count = promoproducts_count;
    }
}
