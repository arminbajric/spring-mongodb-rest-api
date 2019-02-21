package com.example.simpleusersapi.service;

import com.example.simpleusersapi.news.NewsModel;
import com.example.simpleusersapi.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<NewsModel> getAll() {

        return newsRepository.findAll();
    }

    @Override
    public List<NewsModel> getByCategory(String category) {

        return newsRepository.findAllByCategory(category);
    }
}
