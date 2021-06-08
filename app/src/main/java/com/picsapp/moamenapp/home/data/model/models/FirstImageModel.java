package com.picsapp.moamenapp.home.data.model.models;

public class FirstImageModel {

    private String image;

    public FirstImageModel(String image) {
        this.image = image;
    }

    public String getFirstImageUrl() {
        return image;
    }

    public void setFirstImageUrl(String image) {
        this.image = image;
    }
}