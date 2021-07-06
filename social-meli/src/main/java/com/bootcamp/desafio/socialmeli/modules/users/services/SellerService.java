package com.bootcamp.desafio.socialmeli.modules.users.services;

import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerWithFollowerListDTO;
import com.bootcamp.desafio.socialmeli.modules.users.repositories.SellerRepository;
import com.bootcamp.desafio.socialmeli.modules.users.repositories.UserRepository;
import com.bootcamp.desafio.socialmeli.shared.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    private final UserRepository userRepository;

    @Autowired
    public SellerService(SellerRepository sellerRepository, UserRepository userRepository) {
        this.sellerRepository = sellerRepository;
        this.userRepository = userRepository;
    }

    public Seller findById(Long sellerId) {
        Seller seller = this.sellerRepository.findById(sellerId);

        if (seller != null) {
            return seller;
        }
        throw new BadRequestException();
    }

    public SellerWithFollowerListDTO findFollowersList(Long sellerId) {
        Seller seller = this.findById(sellerId);
        List<User> users = this.userRepository.findUsersWithSeller(seller);

        return SellerWithFollowerListDTO.convert(seller, users);
    }

    public Seller findFollowerCount(Long sellerId) {
        return this.findById(sellerId);
    }
}
