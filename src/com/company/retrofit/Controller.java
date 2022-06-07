package com.company.retrofit;

import com.company.Main;
import com.company.retrofit.model.PicturesCollection;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Controller {

    private static final PhotoService SERVICE = ApiHolder.buildRetrofit().create(PhotoService.class);
    private static final String ACCESS_TOKEN = "uchOxFHxEaz69gYAwGb6UHOVHA_XsKULPPJGmZb9pb4";
    private static String per_page = "29";

    public void getPictures(int page){
        Call<PicturesCollection> callAsync = SERVICE.getPictures("office",ACCESS_TOKEN,String.valueOf(page), per_page,"black_and_white");
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
