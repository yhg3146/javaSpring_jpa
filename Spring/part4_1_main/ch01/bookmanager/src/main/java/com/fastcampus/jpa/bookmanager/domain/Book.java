package com.fastcampus.jpa.bookmanager.domain;

//import com.fastcampus.jpa.bookmanager.domain.converter.BookStatusConverter;
import com.fastcampus.jpa.bookmanager.domain.converter.BookStatusConverter;
import com.fastcampus.jpa.bookmanager.repository.dto.BookStatus;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Where(clause = "deleted = false")
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    private  String name;

    private String category;

    private long authorId;

//    private long publisherId;

    @OneToOne
    @ToString.Exclude
    private BookReviewInfo bookReviewInfo;

    @OneToMany
    @JoinColumn(name="book_id")
    @ToString.Exclude
    private List<Review> reviews = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE})
    @ToString.Exclude
    private Publisher publisher;

    @OneToMany
    @JoinColumn(name="book_id")
    @ToString.Exclude
    private List<BookAndAuthor> bookAndAuthors =new ArrayList<>();

/*

    @OneToMany
    @JoinColumn(name="book_id")
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();
*/


    private boolean deleted ;

//    @Convert(converter = BookStatusConverter.class)
    private BookStatus status;//판매상태

    public void addBookAndAuthor(BookAndAuthor... bookAndAuthor){
        Collections.addAll(this.bookAndAuthors,bookAndAuthor);
    }





 /*   @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;*/

/*    @PrePersist
    public void prePersist(){
        this.createdAt=LocalDateTime.now();
        this.updatedAt=LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt=LocalDateTime.now();
    }*/
}
