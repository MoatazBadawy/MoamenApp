package com.picsapp.moamenapp.home.model;


public class DailyImageModel {

    private String image;

    public DailyImageModel(String image) {
        this.image = image;
    }

    public String getDailyImageUrl() {
        return image;
    }

    public void setDailyImageUrl(String image) {
        this.image = image;
    }
}
