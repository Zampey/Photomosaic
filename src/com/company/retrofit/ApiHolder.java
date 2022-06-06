package com.company.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {
    private static final String URL = "https://api.unsplash.com/";
    private static final Gson GSON = new GsonBuilder().setLenient().create();

    public static Retrofit buildRetrofit(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(GSON))
                .client(httpClient.build())
                .build();
        return retrofit;
    }
}
