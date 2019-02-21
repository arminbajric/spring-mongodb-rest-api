package com.example.simpleusersapi.repository;

import com.example.simpleusersapi.news.CommentsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentRepository extends MongoRepository<CommentsModel,String> {



}
