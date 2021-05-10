package com.picsapp.moamenapp.home.data.model;

import java.util.List;

public class HomeResponse {

    private final List<DailyImageModel> dailyImage;
    private final List<FirstImageModel> firstImage;
    private List<LiveModel> live;
    private final List<DailyFadelModel> dailyFadel;
    private final List<SaleheenSaidModel> saleheenSaid;

    public HomeResponse(List<DailyImageModel> dailyImage, List<FirstImageModel> firstImage, List<LiveModel> live, List<DailyFadelModel> dailyFadel, List<SaleheenSaidModel> saleheenSaid) {
        this.dailyImage = dailyImage;
        this.firstImage = firstImage;
        this.live = live;
        this.dailyFadel = dailyFadel;
        this.saleheenSaid = saleheenSaid;
    }

    public List<DailyFadelModel> getDailyFadel() {
        return dailyFadel;
    }

    public List<SaleheenSaidModel> getSaleheenSaid() {
        return saleheenSaid;
    }
    public List<DailyImageModel> getDailyImage() {
        return dailyImage;
    }

    public List<FirstImageModel> getFirstImage() {
        return firstImage;
    }

    public List<LiveModel> getLive() {
        return live;
    }

    public void setLive(List<LiveModel> live) {
        this.live = live;
    }
}
