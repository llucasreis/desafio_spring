package com.bootcamp.desafio.socialmeli.shared.helpers;

import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;

import java.util.Comparator;

public class ComparatorHelper {
    public static <T extends Comparable<? super T>> Comparator<T> getComparatorOrder(OrderBy orderBy) {
        if (orderBy.getValue().contains("asc")) {
            return Comparator.naturalOrder();
        }
        return Comparator.reverseOrder();
    }
}
