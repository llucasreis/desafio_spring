package com.bootcamp.desafio.socialmeli.modules.products.services;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;
import com.bootcamp.desafio.socialmeli.modules.products.repositories.PostRepository;
import com.bootcamp.desafio.socialmeli.shared.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post create(PostFormDTO formDTO) {
        Post postAlreadyExist = this.postRepository.findById(formDTO.getId_post());

        if (postAlreadyExist == null) {
            return this.postRepository.create(formDTO.convert());
        }
        throw new BadRequestException();
    }
}
