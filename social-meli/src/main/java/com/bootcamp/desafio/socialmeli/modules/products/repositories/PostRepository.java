package com.bootcamp.desafio.socialmeli.modules.products.repositories;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;

import java.util.Date;
import java.util.List;

public interface PostRepository {
    Post create(Post post);
    Post findById(Long id);
    List<Post> findPostsBySellerId(Long id);
    List<Post> findPostsBySellerId(Long id, Date filterDate);
    List<Post> findPostsBySellersOrderByDate(List<Seller> sellers, Date filterDate, OrderBy orderBy);
    List<Post> findPromoPostsBySellerId(Long id);
    List<Post> findPromoPostsBySellerId(Long id, OrderBy orderBy);
}
