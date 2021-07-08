package com.bootcamp.desafio.socialmeli.modules.users.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {

    private List<Customer> followers;

    public Seller() {
        this.followers = new ArrayList<>();
    }

    public Seller(Long userId, String userName) {
        super(userId, userName, UserType.SELLER);
        this.followers = new ArrayList<>();
    }

    public List<Customer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Customer> followers) {
        this.followers = followers;
    }

    public void removeFollower(Customer customer) {
        this.followers.remove(customer);
    }

    public void addFollower(Customer customer) {
        this.followers.add(customer);
    }

    public boolean followerAlreadyExist(Customer customer) {
        return this.followers.contains(customer);
    }

    @Override
    public int compareTo(User o) {
        return this.getUserName().compareTo(o.getUserName());
    }
}
