package com.bootcamp.desafio.socialmeli.modules.users.services;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.domain.UserType;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerWithFollowerListDTO;
import com.bootcamp.desafio.socialmeli.modules.users.repositories.UserRepository;
import com.bootcamp.desafio.socialmeli.shared.exceptions.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long userId, UserType userType) {
        User user = this.userRepository.findById(userId);

        if (user != null && user.getUserType().equals(userType)) {
            return user;
        }
        throw new BadRequestException();
    }

    public void followSeller(Long userId, Long userIdToFollow) {
        User userCustomer = this.findById(userId, UserType.CUSTOMER);
        User userSeller = this.findById(userIdToFollow, UserType.SELLER);

        this.userRepository.followSeller(userCustomer, userSeller);
    }

    public Seller findFollowersCount(Long userId) {
        return (Seller) this.findById(userId, UserType.SELLER);
    }

    public Customer findFollowedList(Long userId) {
        return (Customer) this.findById(userId, UserType.CUSTOMER);
    }

    public SellerWithFollowerListDTO findFollowersList(Long userId) {
        Seller seller = (Seller) this.findById(userId, UserType.SELLER);

        List<Customer> customers = this.userRepository.findCustomersWithSeller(seller);

        return SellerWithFollowerListDTO.convert(seller, customers);
    }
}
