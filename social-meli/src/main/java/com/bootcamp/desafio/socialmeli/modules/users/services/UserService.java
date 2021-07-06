package com.bootcamp.desafio.socialmeli.modules.users.services;

import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.repositories.SellerRepository;
import com.bootcamp.desafio.socialmeli.modules.users.repositories.UserRepository;
import com.bootcamp.desafio.socialmeli.shared.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final SellerRepository sellerRepository;

    @Autowired
    UserService(UserRepository userRepository, SellerRepository sellerRepository) {
        this.userRepository = userRepository;
        this.sellerRepository = sellerRepository;
    }

    public User findById(Long userId) {
        User user = this.userRepository.findById(userId);

        if (user != null) {
            return user;
        }
        throw new BadRequestException();
    }

    public void followUser(Long userId, Long userIdToFollow) {
        User userFound = this.userRepository.findById(userId);
        Seller sellerFound = this.sellerRepository.findById(userIdToFollow);

        if (userFound != null && sellerFound != null) {
            userFound.addToFollow(sellerFound);
            sellerFound.addFollower(userFound);

            this.userRepository.update(userFound);
            this.sellerRepository.update(sellerFound);
        } else {
            throw new BadRequestException();
        }
    }

    public User findFollowedList(Long userId) {
        return this.findById(userId);
    }
}
