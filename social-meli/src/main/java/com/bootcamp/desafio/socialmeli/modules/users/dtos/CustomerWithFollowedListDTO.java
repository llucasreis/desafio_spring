package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;

import java.util.List;

public class CustomerWithFollowedListDTO {
    private Long userId;
    private String userName;
    private List<SellerDTO> followed;

    public CustomerWithFollowedListDTO() {
    }

    public CustomerWithFollowedListDTO(Long userId, String userName, List<SellerDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

    public static CustomerWithFollowedListDTO convert(Customer customer) {
        return new CustomerWithFollowedListDTO(
                customer.getUserId(),
                customer.getUserName(),
                SellerDTO.convert(customer.getFollowed())
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

    public List<SellerDTO> getFollowed() {
        return followed;
    }

    public void setFollowed(List<SellerDTO> followed) {
        this.followed = followed;
    }
}
