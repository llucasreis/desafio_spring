package com.bootcamp.desafio.socialmeli.modules.users.domain;

public abstract class AbstractUser {
    private Long userId;
    private String userName;

    public AbstractUser() {
    }

    public AbstractUser(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
