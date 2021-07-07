package com.bootcamp.desafio.socialmeli.modules.products.services;

import com.bootcamp.desafio.socialmeli.modules.products.dtos.*;

public interface PostService {
    void create(PostFormDTO formDTO);
    void create(PostPromoFormDTO formDTO);
    CustomerSellersPostsDTO findFollowedPostsList(Long userId, String order);
    SellerPromoPostsDTO findSellerPromoPostsList(Long id);
    SellerPromoPostCountDTO findSellerPromoCount(Long id);
}
