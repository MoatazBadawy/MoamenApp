package com.picsapp.moamenapp.home.request;

import com.picsapp.moamenapp.home.model.HomeResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIServiceHome {

    @GET("homepage.json")
    Call<HomeResponse> getHomeObjectsList();
}