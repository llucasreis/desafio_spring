package com.bootcamp.desafio.socialmeli.shared.utils;

import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;
import com.bootcamp.desafio.socialmeli.shared.exceptions.IllegalOrderValueException;

import java.util.Arrays;

public class EnumUtil {
    public static OrderBy checkIfValidOrderByField(String order, String field) {
        OrderBy validOrder = Arrays.stream(OrderBy.values())
                .filter(o -> o.getValue().equals(order))
                .findFirst().orElse(null);

        if (validOrder == null || !validOrder.getValue().contains(field)) {
            throw new IllegalOrderValueException();
        }

        return validOrder;
    }
}
