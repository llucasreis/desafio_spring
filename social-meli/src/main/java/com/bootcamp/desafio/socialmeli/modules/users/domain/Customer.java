package com.bootcamp.desafio.socialmeli.modules.users.domain;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {

    private List<Seller> followed;
    private UserType userType;

    public Customer() {
        this.followed = new ArrayList<>();
    }

    public Customer(Long userId, String userName) {
        super(userId, userName, UserType.CUSTOMER);
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
