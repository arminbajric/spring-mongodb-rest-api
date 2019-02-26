package com.example.simpleusersapi.controller;


import com.example.simpleusersapi.news.NewsResponseHomeModel;
import com.example.simpleusersapi.service.NewsService;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
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
    public ResponseEntity getByCategory(@PathVariable(value="category") String category) {

        if(category.equals("lastest"))
        {
            Pageable pageable=PageRequest.of(0,6,Sort.by("publish").descending());
            NewsResponseHomeModel newsResponseHomeModel=new NewsResponseHomeModel();
            newsResponseHomeModel.setLastest(newsService.getLastest(pageable));
            pageable=PageRequest.of(1,6,Sort.by("publish").descending());
            newsResponseHomeModel.setSport( newsService.getPreviewByCategory("Sport",pageable));
            newsResponseHomeModel.setFun((newsService.getPreviewByCategory("Fun",pageable)));
            newsResponseHomeModel.setLifestyle(newsService.getPreviewByCategory("Lifestyle",pageable));
            newsResponseHomeModel.setOther(newsService.getPreviewByCategory("Other",pageable));

            return ResponseEntity.ok().body(newsResponseHomeModel);
        }

        else {
            Pageable pageable=PageRequest.of(0,15,Sort.by("publish").descending());
            category=category.substring(0, 1).toUpperCase() + category.substring(1);
            return ResponseEntity.ok().body(newsService.getByCategory(category,pageable));
        }
        }
    @RequestMapping(value="/home/{category}/pages",method = RequestMethod.GET,headers = "Accept=application/json")
    public ResponseEntity getByCategoryPages(@PathVariable(value="category") String category, @PathParam(value="page") int page) {


            Pageable pageable = PageRequest.of(page - 1, 9, Sort.by("publish").descending());
            NewsResponseHomeModel newsResponseHomeModel = new NewsResponseHomeModel();
            switch(category){
                case "sport":
                    return ResponseEntity.ok().body(newsService.getPreviewByCategory("Sport", pageable));

                case "fun":
                    return ResponseEntity.ok().body(newsService.getPreviewByCategory("Fun", pageable));

                case "lifestyle":
                    return ResponseEntity.ok().body(newsService.getPreviewByCategory("Lifestyle", pageable));

                case "other":
                    return ResponseEntity.ok().body(newsService.getPreviewByCategory("Other", pageable));

                default:
                    return ResponseEntity.badRequest().body("URL error!");
            }



    }
}

