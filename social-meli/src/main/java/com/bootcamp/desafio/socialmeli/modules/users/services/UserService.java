package com.bootcamp.desafio.socialmeli.modules.users.services;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.domain.UserType;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerWithFollowerListDTO;

public interface UserService {
    User findById(Long userId, UserType userType);
    void followSeller(Long userId, Long userIdToFollow);
    Seller findFollowersCount(Long userId);
    Customer findFollowedList(Long userId);
    SellerWithFollowerListDTO findFollowersList(Long userId);
}
