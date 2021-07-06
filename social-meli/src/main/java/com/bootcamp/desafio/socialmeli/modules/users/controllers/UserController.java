package com.bootcamp.desafio.socialmeli.modules.users.controllers;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerFollowerCountDTO;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerWithFollowerListDTO;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.UserWithFollowedListDTO;
import com.bootcamp.desafio.socialmeli.modules.users.services.SellerService;
import com.bootcamp.desafio.socialmeli.modules.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final SellerService sellerService;

    @Autowired
    UserController(UserService userService, SellerService sellerService) {
        this.userService = userService;
        this.sellerService = sellerService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable Long userId, @PathVariable Long userIdToFollow) {
        this.userService.followUser(userId, userIdToFollow);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowerCountDTO> findFollowerCount(@PathVariable("userId") Long sellerId) {
        Seller seller = this.sellerService.findFollowerCount(sellerId);

        return new ResponseEntity<>(SellerFollowerCountDTO.convert(seller), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerWithFollowerListDTO> findFollowersList(@PathVariable("userId") Long sellerId) {
        SellerWithFollowerListDTO seller = this.sellerService.findFollowersList(sellerId);

        return new ResponseEntity<>(seller, HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<UserWithFollowedListDTO> findFollowedList(@PathVariable Long userId) {
        User user = this.userService.findFollowedList(userId);

        return new ResponseEntity<>(UserWithFollowedListDTO.convert(user), HttpStatus.OK);
    }
}
