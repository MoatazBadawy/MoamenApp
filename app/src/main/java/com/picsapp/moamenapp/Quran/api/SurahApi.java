package com.picsapp.moamenapp.Quran.api;

import com.picsapp.moamenapp.Quran.model.SurahResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SurahApi {
    @GET("mihrabi//json/quran/surah.json")
    Call<SurahResponse> getSurahList();
}
