package com.picsapp.moamenapp.home.model;

import java.util.List;

public class HomeResponse {

    private List<DailyImageModel> dailyImage;
    private List<FirstImageModel> firstImage;
    private List<LiveModel> live;
    private List<DailyFadelModel> dailyFadel;
    private List<SaleheenSaidModel> saleheenSaid;
    private List<DailyHadeethModel> dailyHadeeth;

    public HomeResponse(List<DailyImageModel> dailyImage, List<FirstImageModel> firstImage, List<LiveModel> live, List<DailyFadelModel> dailyFadel, List<SaleheenSaidModel> saleheenSaid, List<DailyHadeethModel> dailyHadeeth) {
        this.dailyImage = dailyImage;
        this.firstImage = firstImage;
        this.live = live;
        this.dailyFadel = dailyFadel;
        this.saleheenSaid = saleheenSaid;
        this.dailyHadeeth = dailyHadeeth;
    }

    public List<DailyFadelModel> getDailyFadel() {
        return dailyFadel;
    }

    public void setDailyFadel(List<DailyFadelModel> dailyFadel) {
        this.dailyFadel = dailyFadel;
    }

    public List<SaleheenSaidModel> getSaleheenSaid() {
        return saleheenSaid;
    }

    public void setSaleheenSaid(List<SaleheenSaidModel> saleheenSaid) {
        this.saleheenSaid = saleheenSaid;
    }

    public List<DailyHadeethModel> getDailyHadeeth() {
        return dailyHadeeth;
    }

    public void setDailyHadeeth(List<DailyHadeethModel> dailyHadeeth) {
        this.dailyHadeeth = dailyHadeeth;
    }

    public List<DailyImageModel> getDailyImage() {
        return dailyImage;
    }

    public void setDailyImage(List<DailyImageModel> dailyImage) {
        this.dailyImage = dailyImage;
    }

    public List<FirstImageModel> getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(List<FirstImageModel> firstImage) {
        this.firstImage = firstImage;
    }

    public List<LiveModel> getLive() {
        return live;
    }

    public void setLive(List<LiveModel> live) {
        this.live = live;
    }
}
