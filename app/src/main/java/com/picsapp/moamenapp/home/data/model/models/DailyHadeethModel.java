package com.picsapp.moamenapp.home.data.model.models;

public class DailyHadeethModel {

    private String text;

    public DailyHadeethModel(String text) {
        this.text = text;
    }

    public String getDailyHadeehText() {
        return text;
    }

    public void setDailyHadeehText(String text) {
        this.text = text;
    }
}