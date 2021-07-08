package com.bootcamp.desafio.socialmeli.shared.utils;

import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;
import com.bootcamp.desafio.socialmeli.shared.exceptions.IllegalOrderValueException;

import java.util.Arrays;

public class EnumUtil {
    public static OrderBy getOrderByValue(String order) {
        OrderBy validOrder = Arrays.stream(OrderBy.values())
                .filter(o -> o.getValue().equals(order))
                .findFirst().orElse(null);

        if (validOrder == null) {
            throw new IllegalOrderValueException();
        }

        return validOrder;
    }
}
