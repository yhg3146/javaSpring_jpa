package com.example.restaurant_practice.controller;

import com.example.restaurant_practice.wishlist.dto.WishListDto;
import com.example.restaurant_practice.wishlist.service.WishListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
@RequiredArgsConstructor
public class ApiController {

    private final WishListService wishListService;


    @GetMapping("/search") //찾기
    public WishListDto search(@RequestParam String query){
        return wishListService.search(query);
    }

    @PostMapping("") //추가
    public void add(@RequestBody WishListDto wishListDto){
        wishListService.add(wishListDto);
    }

    @GetMapping("/all")
    public List<WishListDto> findAll(){
        return wishListService.findAll();
    }

    @DeleteMapping("/{index}")
    public void delete(@PathVariable int index){
        wishListService.delete(index);
    }

    @PostMapping("{index}")
    public void visit(@PathVariable int index){
        wishListService.visit(index);
    }

}
