package com.bootcamp.desafio.socialmeli.modules.products.controllers;

import com.bootcamp.desafio.socialmeli.modules.products.dtos.CustomerSellersPostsDTO;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;
import com.bootcamp.desafio.socialmeli.modules.products.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/newpost")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostFormDTO formDTO) {
        this.postService.create(formDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<CustomerSellersPostsDTO> findFollowedPostsList(@PathVariable Long userId) {
        CustomerSellersPostsDTO customerSellersPostsDTO = this.postService.findFollowedPostsList(userId);

        return ResponseEntity.ok(customerSellersPostsDTO);
    }
}
