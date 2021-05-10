package com.picsapp.moamenapp.home.ui.viewmodel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.picsapp.moamenapp.home.data.model.HomeResponse;
import com.picsapp.moamenapp.home.data.api.APIServiceHome;
import com.picsapp.moamenapp.home.data.request.RetroInstanceHome;
import com.picsapp.moamenapp.home.utils.Resource;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    public LiveData<Resource<HomeResponse>> makeApiCallHome() {
        final MutableLiveData<Resource<HomeResponse>> homeObjectsList = new MutableLiveData<>();

        homeObjectsList.setValue(Resource.loading());
        APIServiceHome apiServiceHome = RetroInstanceHome.getRetroClientHome().create(APIServiceHome.class);
        Call<HomeResponse> call = apiServiceHome.getHomeObjectsList();
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(@NotNull Call<HomeResponse> call, @NotNull Response<HomeResponse> response) {
                homeObjectsList.postValue(Resource.success(response.body()));

            }

            @Override
            public void onFailure(@NotNull Call<HomeResponse> call, @NotNull Throwable t) {
                homeObjectsList.setValue(Resource.error(t.getMessage() != null ? t.getMessage() : "Unknown Error"));
            }
        });

        return homeObjectsList;
    }
}
