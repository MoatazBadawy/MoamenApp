package com.picsapp.moamenapp.home.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.picsapp.moamenapp.home.model.HomeResponse;
import com.picsapp.moamenapp.home.request.APIServiceHome;
import com.picsapp.moamenapp.home.request.RetroInstanceHome;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    public LiveData<HomeResponse> makeApiCallHome() {
        MutableLiveData<HomeResponse> homeObjectsList = new MutableLiveData<>();
        APIServiceHome apiServiceHome = RetroInstanceHome.getRetroClientHome().create(APIServiceHome.class);
        Call<HomeResponse> call = apiServiceHome.getHomeObjectsList();
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(@NotNull Call<HomeResponse> call, @NotNull Response<HomeResponse> response) {
                homeObjectsList.postValue(response.body());
            }

            @Override
            public void onFailure(@NotNull Call<HomeResponse> call, @NotNull Throwable t) {
                homeObjectsList.postValue(null);
            }
        });

        return homeObjectsList;
    }
}
