package com.bootcamp.desafio.socialmeli.modules.products.dtos;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;

import java.util.List;

public class CustomerSellersPostsDTO {
    private Long userId;
    private List<PostDTO> posts;

    public CustomerSellersPostsDTO() {
    }

    public CustomerSellersPostsDTO(Long userId, List<PostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public static CustomerSellersPostsDTO convert(Long userId, List<Post> posts) {
        return new CustomerSellersPostsDTO(
                userId,
                PostDTO.convert(posts)
        );
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
