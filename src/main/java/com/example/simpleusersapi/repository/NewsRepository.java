package com.example.simpleusersapi.repository;

import com.example.simpleusersapi.news.NewsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NewsRepository extends MongoRepository<NewsModel, String> {
List<NewsModel> findAllByCategory(String category);


}
