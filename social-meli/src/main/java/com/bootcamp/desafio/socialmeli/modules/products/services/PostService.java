package com.bootcamp.desafio.socialmeli.modules.products.services;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;

public interface PostService {
    Post create(PostFormDTO formDTO);
}
