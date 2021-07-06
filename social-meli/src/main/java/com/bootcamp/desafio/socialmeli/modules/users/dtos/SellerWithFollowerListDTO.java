package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;

import java.util.List;

public class SellerWithFollowerListDTO {
    private Long userId;
    private String userName;
    private List<CustomerDTO> followers;

    public SellerWithFollowerListDTO() {
    }

    public SellerWithFollowerListDTO(Long userId, String userName, List<CustomerDTO> followers) {
        this.userId = userId;
        this.userName = userName;
        this.followers = followers;
    }

    public static SellerWithFollowerListDTO convert(Seller seller, List<Customer> customers) {

        return new SellerWithFollowerListDTO(
                seller.getUserId(),
                seller.getUserName(),
                CustomerDTO.convert(customers)
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

    public List<CustomerDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<CustomerDTO> followers) {
        this.followers = followers;
    }
}
