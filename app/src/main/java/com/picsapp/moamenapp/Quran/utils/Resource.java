package com.picsapp.moamenapp.Quran.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.picsapp.moamenapp.Quran.model.Data;

import java.util.List;

public class Resource<T> {

    @NonNull
    public final Status status;

    @Nullable
    public final T data;

    @Nullable
    public final String message;


    public Resource(@NonNull Status status, @Nullable T data, @Nullable String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Resource<T> success (@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<List<Data>> error(@NonNull String msg) {
        return new Resource<>(Status.ERROR, null, msg);
    }

    public static <T> Resource<List<Data>> loading() {
        return new Resource<>(Status.LOADING, null, null);
    }
}