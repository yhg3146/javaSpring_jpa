package com.fastcampus.jpa.bookmanager.repository;

import com.fastcampus.jpa.bookmanager.domain.Book;
import com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Tuple;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Modifying
    @Query(value ="update book set category='none'",nativeQuery = true)
    void update();

    List<Book> findByCategoryIsNull();
    List<Book> findByDeletedFalse();
    List<Book> findByCategoryIsNullAndDeletedFalse();

    List<Book> findByCategoryIsNullAndNameEqualsAndCreatedAtGreaterThanEqualAndUpdatedAtGreaterThanEqual(String name, LocalDateTime createdAt,LocalDateTime updatedAt);

    @Query("select b from Book b " +
            "where name =:name and created_at >=:createdAt and updatedAt >=:updatedAt and category is null")
    List<Book> findByNameRecently(
            @Param("name") String name,
            @Param("createdAt") LocalDateTime createdAt,
            @Param("updatedAt") LocalDateTime updatedAt);

    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name,b.category) from Book b")
    List<BookNameAndCategory> findBookAndNameCategory();

    @Query(value = "select new com.fastcampus.jpa.bookmanager.repository.dto.BookNameAndCategory(b.name,b.category) from Book b")
    Page<BookNameAndCategory> findBookAndNameCategory(Pageable pageable);

    @Query(value = "select * from book",nativeQuery = true)
    List<Book> findAllCustom();

    @Modifying
    @Transactional
    @Query(value = "update book set category='IT전문서'",nativeQuery = true)
    int updateCategories();

    @Query(value = "show tables",nativeQuery = true)
    List<String> showTables();

    @Query(value ="select * from book order by id desc limit 1",nativeQuery = true)
    Map<String,Object> findRowRecord();
}
