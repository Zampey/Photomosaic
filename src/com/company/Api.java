package com.company;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface Api {

    @GET("search/collections")
    Call<ResponseImpl> getpictures(@Query("query")String query, @Query("client_id") String token);

}
