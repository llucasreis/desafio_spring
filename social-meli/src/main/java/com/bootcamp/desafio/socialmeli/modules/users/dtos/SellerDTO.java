package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;

import java.util.List;
import java.util.stream.Collectors;

public class SellerDTO {
    private Long userId;
    private String userName;

    public SellerDTO() {
    }

    public SellerDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public static SellerDTO convert(Seller seller) {
        return new SellerDTO(
                seller.getUserId(),
                seller.getUserName()
        );
    }

    public static List<SellerDTO> convert(List<Seller> users) {
        return users.stream().map(SellerDTO::convert).collect(Collectors.toList());
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
}
