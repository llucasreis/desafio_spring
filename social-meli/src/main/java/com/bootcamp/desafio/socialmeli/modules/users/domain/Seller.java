package com.bootcamp.desafio.socialmeli.modules.users.domain;

import java.util.ArrayList;
import java.util.List;

public class Seller extends AbstractUser {
    private List<User> followers;
    private int followersCount;

    public Seller() {
        this.followers = new ArrayList<>();
        this.followersCount = 0;
    }

    public Seller(Long userId, String userName) {
        super(userId, userName);
        this.followers = new ArrayList<>();
        this.followersCount = 0;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    public void addFollower(User user) {
        this.followers.add(user);
        this.followersCount++;
    }
}
