package com.example.simpleusersapi.repository;

import com.example.simpleusersapi.news.NewsModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface NewsRepository extends MongoRepository<NewsModel,String> {
    NewsModel getNewsModelBytitle(String title);
    List<NewsModel> getNewsModelByCategory(String category);
    List<NewsModel> getAllByQuantity(int quantity);
}
