package com.bootcamp.desafio.socialmeli.modules.users.repositories;

import com.bootcamp.desafio.socialmeli.modules.users.domain.Seller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class SellerRepository {

    private final List<Seller> sellers;

    SellerRepository() {
        this.sellers = new ArrayList<>(Arrays.asList(
                new Seller(1L, "vendedor1"),
                new Seller(2L, "vendedor2"),
                new Seller(3L, "vendedor3")
        ));
    }

    private int findIndex(Long id) {
        int arrayIndex = -1;
        for (int i = 0; i < this.sellers.size(); i++) {
            if (this.sellers.get(i).getUserId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public Seller findById(Long id) {
        return this.sellers.stream().filter(s -> s.getUserId().equals(id)).findFirst().orElse(null);
    }

    public void update(Seller seller) {
        int index = this.findIndex(seller.getUserId());

        this.sellers.set(index, seller);
    }
}
