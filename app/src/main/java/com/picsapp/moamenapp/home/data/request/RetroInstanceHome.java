package com.picsapp.moamenapp.home.data.request;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstanceHome {


    public static String BASE_URL = "https://moatazbadawy.github.io/Data/";

    private static Retrofit retrofit;

    public static Retrofit getRetroClientHome() {

        if(retrofit == null ) {

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
