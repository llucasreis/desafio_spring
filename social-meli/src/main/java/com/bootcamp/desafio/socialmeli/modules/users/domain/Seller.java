package com.bootcamp.desafio.socialmeli.modules.users.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller extends User {

    private List<Customer> followers;
    private int followersCount;

    public Seller() {
        this.followers = new ArrayList<>();
        this.followersCount = 0;
    }

    public Seller(Long userId, String userName) {
        super(userId, userName, UserType.SELLER);
        this.followers = new ArrayList<>();
        this.followersCount = 0;
    }

    public List<Customer> getFollowers() {
        return followers;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public void setFollowers(List<Customer> followers) {
        this.followers = followers;
    }

    public void addFollower(Customer customer) {
        this.followers.add(customer);
        this.followersCount++;
    }

    public boolean followerAlreadyExist(Customer customer) {
        return this.followers.contains(customer);
    }
}
