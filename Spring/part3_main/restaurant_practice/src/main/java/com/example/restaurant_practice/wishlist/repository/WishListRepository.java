package com.example.restaurant_practice.wishlist.repository;

import com.example.restaurant_practice.db.MemoryDbAbstract;
import com.example.restaurant_practice.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbAbstract<WishListEntity> {
}
