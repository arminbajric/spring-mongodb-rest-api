package com.example.simpleusersapi.repository;

import com.example.simpleusersapi.news.NewsModel;

import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface NewsRepository extends MongoRepository<NewsModel, String> {
List<NewsModel> findAllByCategory(String category);
List<NewsModel> findNewsModelsBy(Pageable pageable);


}
