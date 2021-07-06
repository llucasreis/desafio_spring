package com.bootcamp.desafio.socialmeli.modules.users.repositories;

import com.bootcamp.desafio.socialmeli.modules.users.domain.User;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private final List<User> users;

    UserRepository() {
        this.users = new ArrayList<>(Arrays.asList(
                new User(1L, "usuario1"),
                new User(2L, "usuario2"),
                new User(3L, "usuario3")
        ));
    }

    private int findIndex(Long id) {
        int arrayIndex = -1;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public User findById(Long userId) {
        return this.users.stream().filter(u -> u.getUserId().equals(userId)).findFirst().orElse(null);
    }

    public void update(User user) {
        int index = this.findIndex(user.getUserId());

        this.users.set(index, user);
    }

    public List<User> findUsersWithSeller(Seller seller) {
        return this.users.stream().filter(u -> u.getFollowed().contains(seller)).collect(Collectors.toList());
    }
}
