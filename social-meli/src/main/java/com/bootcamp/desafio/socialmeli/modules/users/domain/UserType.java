package com.bootcamp.desafio.socialmeli.modules.users.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UserType {
    CUSTOMER("Usuário"),
    SELLER("Vendedor");

    private String value;

    UserType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @JsonCreator
    public static UserType fromJson(@JsonProperty("name") String name) {
        return valueOf(name);
    }
}
