package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {
    private Long userId;
    private String userName;

    public UserDTO() {
    }

    public UserDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public static UserDTO convert(User user) {
        return new UserDTO(
                user.getUserId(),
                user.getUserName()
        );
    }

    public static List<UserDTO> convert(List<User> users) {
        return users.stream().map(UserDTO::convert).collect(Collectors.toList());
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
}
