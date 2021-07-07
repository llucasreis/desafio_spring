package com.bootcamp.desafio.socialmeli.modules.products.services;

import com.bootcamp.desafio.socialmeli.modules.products.dtos.CustomerSellersPostsDTO;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostPromoFormDTO;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.SellerPromoPostCountDTO;

public interface PostService {
    void create(PostFormDTO formDTO);
    void create(PostPromoFormDTO formDTO);
    CustomerSellersPostsDTO findFollowedPostsList(Long userId, String order);
     SellerPromoPostCountDTO findSellerPromoCount(Long id);
}
