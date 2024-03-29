package com.fastcampus.jpa.bookmanager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Author extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    @OneToMany
    @ToString.Exclude
    @JoinColumn(name="author_id")
    private List<BookAndAuthor> bookAndAuthors = new ArrayList<>();


    public void addBookAndAuthor(BookAndAuthor... bookAndAuthor){
        Collections.addAll(this.bookAndAuthors,bookAndAuthor);
    }

}
