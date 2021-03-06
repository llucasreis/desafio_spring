package com.bootcamp.desafio.socialmeli.modules.products.controllers;

import com.bootcamp.desafio.socialmeli.modules.products.dtos.*;
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

    @PostMapping("/newpromopost")
    public ResponseEntity<?> createPromoPost(@Valid @RequestBody PostPromoFormDTO formDTO) {
        this.postService.create(formDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<CustomerSellersPostsDTO> findFollowedPostsList(
            @PathVariable Long userId, @RequestParam(defaultValue = "") String order) {
        CustomerSellersPostsDTO customerSellersPostsDTO = this.postService.findFollowedPostsList(userId, order);

        return ResponseEntity.ok(customerSellersPostsDTO);
    }

    @GetMapping("/{userId}/countPromo")
    public ResponseEntity<SellerPromoPostCountDTO> findSellerPromoCount(@PathVariable Long userId) {
        SellerPromoPostCountDTO sellerPromoPostCountDTO = this.postService.findSellerPromoCount(userId);

        return ResponseEntity.ok(sellerPromoPostCountDTO);
    }

    @GetMapping("/{userId}/list")
    public ResponseEntity<SellerPromoPostsDTO> findSellerPromoPosts(@PathVariable Long userId,
                                                                    @RequestParam(defaultValue = "") String order) {
        SellerPromoPostsDTO sellerPromoPostsDTO = this.postService.findSellerPromoPostsList(userId, order);

        return ResponseEntity.ok(sellerPromoPostsDTO);
    }
}
