package com.picsapp.moamenapp.home.data.model.models;

public class LiveModel {

    private String image;
    private String url;

    public LiveModel(String image, String url) {
        this.image = image;
        this.url = url;
    }

    public String getImageLiveInfoUrl() {
        return image;
    }

    public void setImageLiveInfoUrl(String image) {
        this.image = image;
    }

    public String getLiveUrl() {
        return url;
    }

    public void setLiveUrl(String url) {
        this.url = url;
    }

}