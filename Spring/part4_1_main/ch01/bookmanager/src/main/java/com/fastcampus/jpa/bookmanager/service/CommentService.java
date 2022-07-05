package com.fastcampus.jpa.bookmanager.service;

import com.fastcampus.jpa.bookmanager.domain.Comment;
import com.fastcampus.jpa.bookmanager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public void init(){
        for(int i=0;i<10;i++){
            Comment comment = new Comment();
            comment.setComment("최고예요");

            commentRepository.save(comment);
        }
    }
    @Transactional
    public void updateSomething(){
        List<Comment> comments = commentRepository.findAll();

        for(Comment comment : comments) {
            comment.setComment("별로예요");
//            commentRepository.save(comment);
        }
    }

    @Transactional
    public void InsertSomething(){
        Comment comment = new Comment();
        comment.setComment("이건뭐죠?");

    }

}
