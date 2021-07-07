package com.bootcamp.desafio.socialmeli.modules.products.services;

import com.bootcamp.desafio.socialmeli.modules.products.domain.Post;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.CustomerSellersPostsDTO;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostFormDTO;
import com.bootcamp.desafio.socialmeli.modules.products.dtos.PostPromoFormDTO;
import com.bootcamp.desafio.socialmeli.modules.products.repositories.PostRepository;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Customer;
import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import com.bootcamp.desafio.socialmeli.modules.users.domain.UserType;
import com.bootcamp.desafio.socialmeli.modules.users.services.UserService;
import com.bootcamp.desafio.socialmeli.shared.exceptions.BadRequestException;
import com.bootcamp.desafio.socialmeli.shared.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public void create(PostFormDTO formDTO) {
        Seller seller = (Seller) userService.findById(formDTO.getUserId(), UserType.SELLER);
        Post postAlreadyExist = this.postRepository.findById(formDTO.getId_post());

        if (seller != null && postAlreadyExist == null) {
            this.postRepository.create(formDTO.convert());
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public void create(PostPromoFormDTO formDTO) {
        Post postAlreadyExist = this.postRepository.findById(formDTO.getId_post());

        if (postAlreadyExist == null) {
            this.postRepository.create(formDTO.convert());
        } else {
            throw new BadRequestException();
        }
    }

    @Override
    public CustomerSellersPostsDTO findFollowedPostsList(Long userId, String order) {
        Customer customer = (Customer) this.userService.findById(userId, UserType.CUSTOMER);
        Date filterDate = DateUtil.getTwoWeeksAgoDate(new Date());

        List<Post> sellerPosts = this.postRepository.findPostsBySellersOrderByDate(
                customer.getFollowed(), filterDate, order);

        return CustomerSellersPostsDTO.convert(userId, sellerPosts);
    }
}
