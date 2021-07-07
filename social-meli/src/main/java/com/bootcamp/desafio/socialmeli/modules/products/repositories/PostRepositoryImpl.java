package com.bootcamp.desafio.socialmeli.modules.products.repositories;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final List<Post> posts;

    PostRepositoryImpl() {
        this.posts = new ArrayList<>();
    }

    @Override
    public Post create(Post post) {
        this.posts.add(post);

        return post;
    }

    @Override
    public Post findById(Long id) {
        return this.posts.stream().filter(p -> p.getId_post().equals(id)).findFirst().orElse(null);
    }
}
