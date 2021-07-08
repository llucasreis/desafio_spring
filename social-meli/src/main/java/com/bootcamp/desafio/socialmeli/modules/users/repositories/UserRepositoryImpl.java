package com.bootcamp.desafio.socialmeli.modules.users.repositories;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.domain.UserType;
import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;
import com.bootcamp.desafio.socialmeli.shared.helpers.ComparatorHelper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final List<User> users;

    UserRepositoryImpl() {
        this.users = new ArrayList<>(Arrays.asList(
                new Customer(1L, "usuario1"),
                new Customer(2L, "usuario2"),
                new Customer(3L, "usuario3"),
                new Seller(4L, "vendedor1"),
                new Seller(5L, "vendedor2"),
                new Seller(6L, "vendedor3")
        ));
    }

    private int findIndex(Long id) {
        int arrayIndex = -1;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId().equals(id)) {
                arrayIndex = i;
                break;
            }
        }

        return arrayIndex;
    }

    @Override
    public boolean followSeller(User userCustomer, User userSeller) {
        Customer customer = (Customer) userCustomer;
        Seller seller = (Seller) userSeller;

        if (!seller.followerAlreadyExist(customer)) {
            customer.addToFollow(seller);
            seller.addFollower(customer);

            this.update(customer);
            this.update(seller);

            return true;
        }
        return false;
    }

    @Override
    public boolean unfollowSeller(User userCustomer, User userSeller) {
        Customer customer = (Customer) userCustomer;
        Seller seller = (Seller) userSeller;

        if (seller.followerAlreadyExist(customer)) {
            customer.unfollow(seller);
            seller.removeFollower(customer);

            this.update(customer);
            this.update(seller);

            return true;
        }
        return false;
    }

    @Override
    public User findById(Long userId) {
        return this.users.stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElse(null);
    }

    @Override
    public void update(User user) {
        int index = this.findIndex(user.getUserId());

        this.users.set(index, user);
    }

    @Override
    public List<Seller> findFollowedList(Customer customer, OrderBy orderBy) {
        return customer.getFollowed().stream()
                .sorted(ComparatorHelper.getComparatorOrder(orderBy))
                .collect(Collectors.toList());
    }

    @Override
    public List<Customer> findCustomersWithSeller(Seller seller, OrderBy orderBy) {
        return this.users.stream()
                .filter(u -> u.getUserType().equals(UserType.CUSTOMER))
                .map(c -> (Customer) c)
                .filter(c -> c.getFollowed().contains(seller))
                .sorted(ComparatorHelper.getComparatorOrder(orderBy))
                .collect(Collectors.toList());
    }
}
