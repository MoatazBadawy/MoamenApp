package com.picsapp.moamenapp.Quran.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.picsapp.moamenapp.Quran.api.ApiClient;
import com.picsapp.moamenapp.Quran.model.Data;
import com.picsapp.moamenapp.Quran.model.SurahResponse;
import com.picsapp.moamenapp.Quran.utils.Resource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {

    public LiveData<Resource<List<Data>>> getSurahList() {
        final MutableLiveData<Resource<List<Data>>> surahResponse = new MutableLiveData<>();

        surahResponse.setValue(Resource.loading());
        ApiClient.getRetrofitInstance().getSurahList()
                .enqueue(new Callback<SurahResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<SurahResponse> call, @NonNull Response<SurahResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            surahResponse.postValue(Resource.success(response.body().getData()));
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<SurahResponse> call, @NonNull Throwable t) {
                        surahResponse.setValue(Resource.error(t.getMessage() != null ? t.getMessage() : "Unknown Error"));
                    }
                });

        return surahResponse;
    }
}
