package com.example.simpleusersapi.repository;

import com.example.simpleusersapi.news.NewsModel;

import com.example.simpleusersapi.news.NewsPreviewModel;
import org.springframework.data.domain.Pageable;

import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface NewsRepository extends MongoRepository<NewsModel, String> {
List<NewsModel> findAllByCategory(String category,Pageable pageable);
List<NewsPreviewModel> getAllByCategory(String category,Pageable pageable);
List<NewsPreviewModel> findNewsModelsBy(Pageable pageable);


}
