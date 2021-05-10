package com.picsapp.moamenapp.home.data.api;

import com.picsapp.moamenapp.home.data.model.HomeResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServiceHome {

    @GET("homepage.json")
    Call<HomeResponse> getHomeObjectsList();
}