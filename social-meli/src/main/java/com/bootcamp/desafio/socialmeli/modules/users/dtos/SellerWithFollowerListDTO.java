package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.User;

import java.util.List;

public class SellerWithFollowerListDTO {
    private Long userId;
    private String userName;
    private List<UserDTO> followers;

    public SellerWithFollowerListDTO() {
    }

    public SellerWithFollowerListDTO(Long userId, String userName, List<UserDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public static SellerWithFollowerListDTO convert(Seller seller, List<User> users) {
        return new SellerWithFollowerListDTO(
                seller.getUserId(),
                seller.getUserName(),
                UserDTO.convert(users)
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

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }
}
