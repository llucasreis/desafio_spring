package com.bootcamp.desafio.socialmeli.modules.users.dtos;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;

import java.util.List;
import java.util.stream.Collectors;

public class CustomerDTO {
    private Long userId;
    private String userName;

    public CustomerDTO() {
    }

    public CustomerDTO(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public static CustomerDTO convert(Customer customer) {
        return new CustomerDTO(
                customer.getUserId(),
                customer.getUserName()
        );
    }

    public static List<CustomerDTO> convert(List<Customer> customers) {
        return customers.stream().map(CustomerDTO::convert).collect(Collectors.toList());
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
