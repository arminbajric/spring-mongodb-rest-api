package com.example.simpleusersapi.service;

import com.example.simpleusersapi.news.NewsModel;
import org.springframework.data.domain.Page;


import java.util.List;

public interface NewsService  {
   List<NewsModel> getAll();
   List<NewsModel> getByCategory(String category);
}
