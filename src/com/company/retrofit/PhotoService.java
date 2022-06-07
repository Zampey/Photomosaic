package com.company.retrofit;

import com.company.retrofit.model.PicturesCollection;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PhotoService {

    @GET("search/photos")
    Call<PicturesCollection> getPictures(@Query("query") String query, @Query("client_id") String token, @Query("page") String page,@Query("per_page") String perPage,@Query("color") String color);

}
