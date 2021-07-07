package com.bootcamp.desafio.socialmeli.modules.products.repositories;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.shared.utils.DateUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImpl implements PostRepository {

    private final List<Post> posts;

    PostRepositoryImpl() {
        this.posts = new ArrayList<>();
    }

    @Override
    public Post create(Post post) {
        this.posts.add(post);

        return post;
    }

    @Override
    public Post findById(Long id) {
        return this.posts.stream().filter(p -> p.getId_post().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Post> findPostsBySellerId(Long id) {
        return this.posts.stream()
                .filter(p -> p.getUserId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findPostsBySellerId(Long id, Date filterDate) {
        return this.posts.stream()
                .filter(p -> p.getUserId().equals(id))
                .filter(p -> p.getDate().after(filterDate))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findPostsBySellersOrderByDate(List<Seller> sellers, Date filterDate, String order) {
        Comparator<Date> dateComparator = order.equals("date_desc") ?
                Comparator.reverseOrder() : Comparator.naturalOrder();

        List<Post> sellerPosts = new ArrayList<>();
        sellers.forEach(s -> {
            sellerPosts.addAll(
            this.findPostsBySellerId(s.getUserId(), filterDate));
        });

        sellerPosts.sort((p1, p2) -> dateComparator.compare(p1.getDate(), p2.getDate()));

        return sellerPosts;
    }

    public List<Post> findPromoPostsBySellerId(Long id) {
        return this.posts.stream()
                .filter(p -> p.getUserId().equals(id))
                .filter(Post::isHasPromo)
                .collect(Collectors.toList());
    }
}
