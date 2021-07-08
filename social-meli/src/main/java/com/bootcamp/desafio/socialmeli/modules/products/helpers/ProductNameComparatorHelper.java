package com.bootcamp.desafio.socialmeli.modules.products.helpers;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;

import java.util.Comparator;

public class ProductNameComparatorHelper implements Comparator<Post> {
    private final OrderBy orderBy;

    public ProductNameComparatorHelper(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public int compare(Post o1, Post o2) {
        int result = o1.getDetail().compareTo(o2.getDetail());

        if (result != 0 && this.orderBy.getValue().contains("desc")) return -result;

        return result;
    }
}
