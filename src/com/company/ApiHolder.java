package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {
    private static final String URL = "https://api.unsplash.com/";
    private static final Gson GSON = new GsonBuilder().setLenient().create();
    private static final Retrofit RETROFIT = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create(GSON)).build();

    public static <T> T createService(Class<T> service) {
        return RETROFIT.create(service);
    }
}
