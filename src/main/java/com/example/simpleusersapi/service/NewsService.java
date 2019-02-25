package com.example.simpleusersapi.service;

import com.example.simpleusersapi.news.NewsModel;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

public interface NewsService  {
   List<NewsModel> getAll();
   List<NewsModel> getByCategory(String category);
   NewsModel addNews(NewsModel newsModel);
   List<NewsModel> getLastest(Pageable pageable);
}
