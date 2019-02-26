package com.example.simpleusersapi.news;

import java.util.Date;

public class NewsPreviewModel {
    private String title;
    private String category;
    private String author;
    private ImagesModel images;

    public ImagesModel getImages() {
        return images;
    }

    public void setImages(ImagesModel images) {
        this.images = images;
    }

    private Date publish;
    private int numberOfComments;
    private String subtitle;




    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public void setNumberOfComments(int numberOfComments) {
        this.numberOfComments = numberOfComments;
    }

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



    public Date getPublish() {
        return publish;
    }

    public void setPublish(Date publish) {
        this.publish = publish;
    }
}
