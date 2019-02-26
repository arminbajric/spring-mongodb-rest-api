package com.example.simpleusersapi.service;

import com.example.simpleusersapi.news.NewsModel;
import com.example.simpleusersapi.news.NewsPreviewModel;
import com.example.simpleusersapi.repository.NewsRepository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Query;
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
    public List<NewsModel> getByCategory(String category,Pageable pageable) {

        return newsRepository.findAllByCategory(category,pageable);

    }

    @Override
    public List<NewsPreviewModel> getPreviewByCategory(String category, Pageable pageable) {
        return newsRepository.getAllByCategory(category,pageable);
    }

    @Override
    public NewsModel addNews(NewsModel newsModel) {
        return newsRepository.save(newsModel);
    }

    @Override
    public List<NewsPreviewModel> getLastest(Pageable pageable) {


        return newsRepository.findNewsModelsBy(pageable);
    }
}
