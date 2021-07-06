package com.bootcamp.desafio.socialmeli.modules.users.domain;

import java.util.ArrayList;
import java.util.List;

public class User extends AbstractUser {

    private List<Seller> followed;

    public User() {
        this.followed = new ArrayList<>();
    }

    public User(Long userId, String userName) {
        super(userId, userName);
        this.followed = new ArrayList<>();
    }

    public List<Seller> getFollowed() {
        return followed;
    }

    public void setFollowed(List<Seller> followed) {
        this.followed = followed;
    }

    public void addToFollow(Seller seller) {
        this.followed.add(seller);
    }
}
