package com.example.restaurant.wishlist.repository;

import com.example.restaurant.wishlist.entity.WishListEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WishListRepositoryTest {

    @Autowired
    private WishListRepository wishListRepository;

    private WishListEntity create(){
        var wishListEntity = new WishListEntity();
        wishListEntity.setTitle("title");
        wishListEntity.setCategory("category");
        wishListEntity.setAddress("address");
        wishListEntity.setRoadAddress("readAddress");
        wishListEntity.setHomePageLink("a");
        wishListEntity.setImageLink("");
        wishListEntity.setVisit(false);
        wishListEntity.setVisitCount(0);
        wishListEntity.setLastVisitDate(null);

        return wishListEntity;
    }

    @Test
    public void saveTest(){
        var wishListEntity =create();
        var expected = wishListRepository.save(wishListEntity);


        Assertions.assertNotNull(expected);
        Assertions.assertEquals(1,expected.getIndex());
    }

    @Test
    public void updateTest(){
        var wishListEntity =create();
        var expected = wishListRepository.save(wishListEntity);

        expected.setTitle("update test");
        var saveEntity = wishListRepository.save(expected);



        Assertions.assertEquals("update test",saveEntity.getTitle());
        Assertions.assertEquals(1,wishListRepository.findAll().size());
    }
    @Test
    public void findByIdTest(){
        var wishListEntity =create();
        wishListRepository.save(wishListEntity);

        var expected = wishListRepository.findById(1);
        Assertions.assertEquals(true,expected.isPresent());
        Assertions.assertEquals(1,expected.get().getIndex());
    }

    @Test
    public void deleteTest(){
        var wishListEntity =create();
        wishListRepository.save(wishListEntity);

        wishListRepository.deleteById(1);

        int count = wishListRepository.findAll().size();

        Assertions.assertEquals(0,count);

    }

    @Test
    public void listAllTest(){
        var wishListEntity1 =create();
        var wishListEntity2 =create();
        wishListRepository.save(wishListEntity1);
        wishListRepository.save(wishListEntity2);

        int count = wishListRepository.findAll().size();
        Assertions.assertEquals(2,count);


    }



}
