package com.example.simpleusersapi.news;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection="news")
public class NewsModel {
   private String title;
   private String category;
   private String author;
   private String[] images;
   private Date publish;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }
}
