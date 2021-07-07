package com.bootcamp.desafio.socialmeli.modules.products.dtos;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;

import java.util.List;

public class SellerPromoPostsDTO {
    private Long userId;
    private String userName;
    private List<PromoPostDTO> posts;

    public SellerPromoPostsDTO() {
    }

    public SellerPromoPostsDTO(Long userId, String userName, List<PromoPostDTO> posts) {
        this.userId = userId;
        this.userName = userName;
        this.posts = posts;
    }

    public static SellerPromoPostsDTO convert(Seller seller, List<Post> posts) {
        return new SellerPromoPostsDTO(
                seller.getUserId(),
                seller.getUserName(),
                PromoPostDTO.convert(posts)
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

    public List<PromoPostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PromoPostDTO> posts) {
        this.posts = posts;
    }
}
