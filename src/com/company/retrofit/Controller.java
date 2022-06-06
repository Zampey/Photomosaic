package com.company.retrofit;

import com.company.Main;
import com.company.retrofit.model.Picture;
import com.company.retrofit.model.PicturesCollection;
import lombok.Getter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class Controller {

    private static final PhotoService SERVICE = ApiHolder.buildRetrofit().create(PhotoService.class);
    private static final String ACCESS_TOKEN = "uchOxFHxEaz69gYAwGb6UHOVHA_XsKULPPJGmZb9pb4";
    private static final String PER_PAGE = "30";
    private static final String PAGE = "1";

    public void getPictures(){
        Call<PicturesCollection> callAsync = SERVICE.getPictures("office",ACCESS_TOKEN,PER_PAGE,PAGE);
        callAsync.enqueue(new Callback<PicturesCollection>() {
            @Override
            public void onResponse(Call<PicturesCollection> call, Response<PicturesCollection> response) {
                Main.showUrls(response.body().getResults());
            }

            @Override
            public void onFailure(Call<PicturesCollection> call, Throwable throwable) {
                System.out.println("Nepodařilo se načíst obrázky");
            }
        });
    }

}
