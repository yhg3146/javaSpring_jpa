package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {


    //3-1
    Optional<User> findByName(String name);

    Optional<User> findUserByNameIs(String name);
    Optional<User> findUserByNameEquals(String name);

    User findByEmail(String email);

    User getByEmail(String email);

    User readByEmail(String email);

    User queryByEmail(String email);

    User searchByEmail(String email);

    User streamByEmail(String email);

    User findUserByEmail(String email);

    List<User> findFist1ByName(String name);

//    List<User> findTop1ByName(String name);
//
//    List<User> findLast1ByName(String name);

/*
    //3-2
    List<User> findByEmailAndName(String email,String name);

    List<User> findByEmailOrName(String email,String name);

    List<User> findByCreatedAtAfter(LocalDateTime yesterday);

    List<User> findByIdAfter(Long id);

    List<User> findByCreatedAtGreaterThan(LocalDateTime yesterday);

    List<User> findByCreatedAtGreaterThanEqual(LocalDateTime yesterday);

    List<User> findByCreatedAtBetween(LocalDateTime yesterday,LocalDateTime tomorrow);

    List<User> findByIdBetween(Long id1,Long id2);
*/

    //3-3
/*    List<User> findByIdIsNotNull();

//    List<User> findByAddressIsNotEmpty();

    List<User> findByNameIn(List<String> names);

    List<User> findByNameStartingWith(String names);

    List<User> findByNameEndingWith(String names);

    List<User> findByNameContains(String names);

    List<User> findByNameLike(String names);*/

    //3-4
    List<User> findTop1ByName(String name);

    List<User> findLast1ByName(String name);

    List<User> findTop1ByNameOrderByIdDesc(String name);

    List<User> findFirstByNameOrderByIdDescEmailAsc(String name);

    List<User> findFirstByName(String name, Sort sort);

    //3-5
    Page<User> findByName(String name, Pageable pageable);

    @Query(value = "select * from user limit 1;",nativeQuery = true)
    Map<String,Object> findRowRecord();

    @Query(value = "select * from user",nativeQuery = true)
    List<Map<String,Object>> findAllRowRecord();




}
