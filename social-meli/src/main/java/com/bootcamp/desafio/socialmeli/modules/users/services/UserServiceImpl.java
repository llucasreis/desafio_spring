package com.bootcamp.desafio.socialmeli.modules.users.services;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.domain.UserType;
import com.bootcamp.desafio.socialmeli.modules.users.dtos.SellerWithFollowerListDTO;
import com.bootcamp.desafio.socialmeli.modules.users.repositories.UserRepository;
import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;
import com.bootcamp.desafio.socialmeli.shared.exceptions.BadRequestException;
import com.bootcamp.desafio.socialmeli.shared.exceptions.NotFoundException;
import com.bootcamp.desafio.socialmeli.shared.utils.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long userId, UserType userType) {
        User user = this.userRepository.findById(userId);

        if (user != null && user.getUserType().equals(userType)) {
            return user;
        }
        throw new NotFoundException(userType.getValue() + " não encontrado");
    }

    @Override
    public void followSeller(Long userId, Long userIdToFollow) {
        User userCustomer = this.findById(userId, UserType.CUSTOMER);
        User userSeller = this.findById(userIdToFollow, UserType.SELLER);

        boolean success = this.userRepository.followSeller(userCustomer, userSeller);

        if (!success) throw new BadRequestException("Este usuário já segue este vendedor");
    }

    @Override
    public void unfollowSeller(Long userId, Long userIdToUnfollow) {
        User userCustomer = this.findById(userId, UserType.CUSTOMER);
        User userSeller = this.findById(userIdToUnfollow, UserType.SELLER);

        boolean success = this.userRepository.unfollowSeller(userCustomer, userSeller);

        if (!success) throw new BadRequestException("Este usuário não segue este vendedor");
    }

    @Override
    public Seller findFollowersCount(Long userId) {
        return (Seller) this.findById(userId, UserType.SELLER);
    }

    @Override
    public Customer findFollowedList(Long userId, String order) {
        OrderBy orderBy = EnumUtil.checkIfValidOrderByField(order, "name");
        Customer customer = (Customer) this.findById(userId, UserType.CUSTOMER);

        customer.setFollowed(this.userRepository.findFollowedList(customer, orderBy));

        return customer;
    }

    @Override
    public SellerWithFollowerListDTO findFollowersList(Long userId, String order) {
        OrderBy orderBy = EnumUtil.checkIfValidOrderByField(order, "name");
        Seller seller = (Seller) this.findById(userId, UserType.SELLER);

        List<Customer> customers = this.userRepository.findCustomersWithSeller(seller, orderBy);

        return SellerWithFollowerListDTO.convert(seller, customers);
    }
}
