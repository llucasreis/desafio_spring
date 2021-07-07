package com.bootcamp.desafio.socialmeli.modules.products.repositories;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;

public interface PostRepository {
    Post create(Post post);
    Post findById(Long id);
}
