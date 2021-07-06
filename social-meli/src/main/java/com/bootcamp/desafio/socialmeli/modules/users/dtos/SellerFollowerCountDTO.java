package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;

public class SellerFollowerCountDTO {

    private Long userId;
    private String userName;
    private int followers_count;

    public SellerFollowerCountDTO() {
    }

    public SellerFollowerCountDTO(Long userId, String userName, int followers_count) {
        this.userId = userId;
        this.userName = userName;
        this.followers_count = followers_count;
    }

    public static SellerFollowerCountDTO convert(Seller seller) {
        return new SellerFollowerCountDTO(
                seller.getUserId(),
                seller.getUserName(),
                seller.getFollowersCount()
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

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
