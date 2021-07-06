package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.User;

import java.util.List;

public class UserWithFollowedListDTO {
    private Long userId;
    private String userName;
    private List<SellerDTO> followed;

    public UserWithFollowedListDTO() {
    }

    public UserWithFollowedListDTO(Long userId, String userName, List<SellerDTO> followed) {
        this.userId = userId;
        this.userName = userName;
        this.followed = followed;
    }

    public static UserWithFollowedListDTO convert(User user) {
        return new UserWithFollowedListDTO(
                user.getUserId(),
                user.getUserName(),
                SellerDTO.convert(user.getFollowed())
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
