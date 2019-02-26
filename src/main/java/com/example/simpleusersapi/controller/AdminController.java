package com.example.simpleusersapi.controller;

import com.example.simpleusersapi.news.ImagesModel;
import com.example.simpleusersapi.news.NewsModel;
import com.example.simpleusersapi.service.NewsService;
import com.example.simpleusersapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class AdminController {
    private final UserService userService;
    private final NewsService newsService;


    public AdminController(UserService userService, NewsService newsService) {
        this.userService = userService;
        this.newsService = newsService;

    }

    @RequestMapping(value = "/cpanel",method = RequestMethod.POST)
    public ResponseEntity doActions(@RequestParam("action") String action,@RequestBody NewsModel model)
    {


      if(action.equals("addnews"))
      {
          newsService.addNews(model);
          return ResponseEntity.status(201).header("Content-Type", "application/json; charset=UTF-8").body(model);
      }
      else {
          return ResponseEntity.status(200).header("Content-Type", "application/json; charset=UTF-8").body(model);
      }
    }

}
