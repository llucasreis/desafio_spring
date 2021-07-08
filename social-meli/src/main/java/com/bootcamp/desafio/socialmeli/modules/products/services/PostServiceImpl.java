package com.bootcamp.desafio.socialmeli.modules.products.services;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.*;
import com.bootcamp.desafio.socialmeli.modules.products.repositories.PostRepository;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.UserType;
import com.bootcamp.desafio.socialmeli.modules.users.services.UserService;
import com.bootcamp.desafio.socialmeli.shared.enums.OrderBy;
import com.bootcamp.desafio.socialmeli.shared.exceptions.ConflictException;
import com.bootcamp.desafio.socialmeli.shared.utils.DateUtil;
import com.bootcamp.desafio.socialmeli.shared.utils.EnumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    private void createPost(Post post) {
        userService.findById(post.getUserId(), UserType.SELLER); //checking if exist
        Post postAlreadyExist = this.postRepository.findById(post.getId_post());

        if (postAlreadyExist != null) throw new ConflictException("Já existe um Post com este ID");

        this.postRepository.create(post);
    }

    @Override
    public void create(PostFormDTO formDTO) {
        this.createPost(formDTO.convert());
    }

    @Override
    public void create(PostPromoFormDTO formDTO) {
        this.createPost(formDTO.convert());
    }

    @Override
    public CustomerSellersPostsDTO findFollowedPostsList(Long userId, String order) {
        OrderBy orderBy = EnumUtil.getOrderByValue(order);
        Customer customer = (Customer) this.userService.findById(userId, UserType.CUSTOMER);
        Date filterDate = DateUtil.getTwoWeeksAgoDate(new Date());

        List<Post> sellerPosts = this.postRepository.findPostsBySellersOrderByDate(
                customer.getFollowed(), filterDate, orderBy);

        return CustomerSellersPostsDTO.convert(userId, sellerPosts);
    }

    @Override
    public SellerPromoPostCountDTO findSellerPromoCount(Long id) {
        Seller seller = (Seller) this.userService.findById(id, UserType.SELLER);

        List<Post> posts = this.postRepository.findPromoPostsBySellerId(id);

        return SellerPromoPostCountDTO.convert(seller, posts.size());
    }

    @Override
    public SellerPromoPostsDTO findSellerPromoPostsList(Long id) {
        Seller seller = (Seller) this.userService.findById(id, UserType.SELLER);

        List<Post> posts = this.postRepository.findPromoPostsBySellerId(id);

        return SellerPromoPostsDTO.convert(seller, posts);
    }
}
