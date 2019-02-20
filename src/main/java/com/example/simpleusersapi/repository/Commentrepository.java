package com.example.simpleusersapi.repository;

import com.example.simpleusersapi.news.CommentsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface Commentrepository extends MongoRepository<CommentsModel,String> {
    List<CommentsModel> getAll();
    CommentsModel addNewComment(CommentsModel commentsModel);


}
