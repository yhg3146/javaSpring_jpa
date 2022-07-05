package com.example.restaurant_practice.wishlist.service;

import com.example.restaurant_practice.naver.NaverClient;
import com.example.restaurant_practice.naver.dto.SearchImageReq;
import com.example.restaurant_practice.naver.dto.SearchLocalReq;
import com.example.restaurant_practice.wishlist.dto.WishListDto;
import com.example.restaurant_practice.wishlist.entity.WishListEntity;
import com.example.restaurant_practice.wishlist.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;


    public WishListDto search(String query){
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setQuery(query);

        var searchLocalRes = naverClient.searchLocal(searchLocalReq);

        if(searchLocalRes.getTotal()>0){
            var localItem = searchLocalRes.getItems().stream().findFirst().get();
            var imageQuery = searchLocalReq.getQuery().replaceAll("<[^>]*>","");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            var searchImageRes = naverClient.searchImage(searchImageReq);
            if(searchImageRes.getTotal()>0) {
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                var wishListDto = new WishListDto();
                wishListDto.setTitle(searchLocalReq.getQuery());
                wishListDto.setCategory(localItem.getCategory());
                wishListDto.setAddress(localItem.getAddress());
                wishListDto.setRoadAddress(localItem.getRoadAddress());
                wishListDto.setHomePageLink(localItem.getLink());
                wishListDto.setImageLink(imageItem.getLink());

                return wishListDto;
            }


            }

        return new WishListDto();

    }

    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);
        var saveEntity = wishListRepository.save(entity);

        return entityToDto(saveEntity);
    }

    public WishListEntity dtoToEntity(WishListDto wishListDto){
        WishListEntity entity= new WishListEntity();

        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setCategory(wishListDto.getCategory());
        entity.setAddress(wishListDto.getAddress());
        entity.setRoadAddress(wishListDto.getRoadAddress());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setVisit(wishListDto.isVisit());
        entity.setVisitCount(wishListDto.getVisitCount());
        entity.setLastVisitDate(wishListDto.getLastVisitDate());

        return entity;

    }

    public WishListDto entityToDto(WishListEntity wishListEntity){
        WishListDto dto= new WishListDto();

        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setCategory(wishListEntity.getCategory());
        dto.setAddress(wishListEntity.getAddress());
        dto.setRoadAddress(wishListEntity.getRoadAddress());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setVisit(wishListEntity.isVisit());
        dto.setVisitCount(wishListEntity.getVisitCount());
        dto.setLastVisitDate(wishListEntity.getLastVisitDate());

        return dto;

    }

    public List<WishListDto> findAll() {
        return wishListRepository.findAll().stream().map(it->entityToDto(it)).collect(Collectors.toList());
    }

    public void delete(int index) {
            wishListRepository.deleteById(index);
    }

    public void visit(int index) {
        var wishItem =wishListRepository.findById(index);
        if(wishItem.isPresent()){
            var item = wishItem.get();
            item.setVisitCount(item.getVisitCount()+1);
            item.setVisit(true);
        }

    }
}
