package com.example.simpleusersapi.controller;

import com.example.simpleusersapi.news.NewsModel;
import com.example.simpleusersapi.service.NewsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }
    @RequestMapping(value="/home",method=RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity getAll(){


        return ResponseEntity.ok().body(newsService.getAll());
    }
    @RequestMapping(value="/home/{category}",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity getByCategory(@PathVariable String category){
        if(category.equals("lastest"))
        {
            Pageable pageable=PageRequest.of(0,6,Sort.by("publish").descending());

            return ResponseEntity.ok().body(newsService.getLastest(pageable));
        }
        else {

            return ResponseEntity.ok().body(newsService.getByCategory(category.substring(0, 1).toUpperCase() + category.substring(1)));
        }
        }
}

