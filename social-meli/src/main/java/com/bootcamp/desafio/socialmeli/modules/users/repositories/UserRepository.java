package com.bootcamp.desafio.socialmeli.modules.users.repositories;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;

import java.util.List;

public interface UserRepository {
    boolean followSeller(User userCustomer, User userSeller);
    boolean unfollowSeller(User userCustomer, User userSeller);
    User findById(Long userId);
    void update(User user);
    List<Customer> findCustomersWithSeller(Seller seller, OrderBy orderBy);
    List<Seller> findFollowedList(Customer customer, OrderBy orderBy);
}
