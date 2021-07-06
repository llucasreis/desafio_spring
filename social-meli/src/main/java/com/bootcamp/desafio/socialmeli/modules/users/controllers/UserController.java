package com.bootcamp.desafio.socialmeli.modules.users.controllers;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerFollowerCountDTO;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerWithFollowerListDTO;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.CustomerWithFollowedListDTO;
import com.bootcamp.desafio.socialmeli.modules.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<?> followSeller(@PathVariable Long userId, @PathVariable Long userIdToFollow) {
        this.userService.followSeller(userId, userIdToFollow);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<SellerFollowerCountDTO> findFollowerCount(@PathVariable Long userId) {
        Seller seller = this.userService.findFollowersCount(userId);

        return ResponseEntity.ok(SellerFollowerCountDTO.convert(seller));
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<SellerWithFollowerListDTO> findFollowersList(@PathVariable("userId") Long sellerId) {
        SellerWithFollowerListDTO seller = this.userService.findFollowersList(sellerId);

        return ResponseEntity.ok(seller);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<CustomerWithFollowedListDTO> findFollowedList(@PathVariable Long userId) {
        Customer customer = this.userService.findFollowedList(userId);

        return new ResponseEntity<>(CustomerWithFollowedListDTO.convert(customer), HttpStatus.OK);
    }
}
