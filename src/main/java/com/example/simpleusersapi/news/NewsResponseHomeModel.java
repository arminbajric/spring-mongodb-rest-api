package com.example.simpleusersapi.news;

import java.util.List;

public class NewsResponseHomeModel {

    private List<NewsPreviewModel> lastest;
    private List<NewsPreviewModel> sport;
    private List<NewsPreviewModel> fun;
    private List<NewsPreviewModel> lifestyle;
    private List<NewsPreviewModel> other;




    public List<NewsPreviewModel> getLastest() {
        return lastest;
    }

    public void setLastest(List<NewsPreviewModel> lastest) {
        this.lastest = lastest;
    }

    public List<NewsPreviewModel> getSport() {
        return sport;
    }

    public void setSport(List<NewsPreviewModel> sport) {
        this.sport = sport;
    }

    public List<NewsPreviewModel> getFun() {
        return fun;
    }

    public void setFun(List<NewsPreviewModel> fun) {
        this.fun = fun;
    }

    public List<NewsPreviewModel> getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(List<NewsPreviewModel> lifestyle) {
        this.lifestyle = lifestyle;
    }

    public List<NewsPreviewModel> getOther() {
        return other;
    }

    public void setOther(List<NewsPreviewModel> other) {
        this.other = other;
    }
}
