package com.bootcamp.desafio.socialmeli.modules.products.services;

import com.bootcamp.desafio.socialmeli.modules.products.dtos.CustomerSellersPostsDTO;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;

public interface PostService {
    void create(PostFormDTO formDTO);
    CustomerSellersPostsDTO findFollowedPostsList(Long userId, String order);
}
