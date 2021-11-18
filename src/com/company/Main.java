package com.company;

import retrofit2.Response;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	   try {
           Response<ResponseImpl> response = ApiHolder.createService(Api.class).getpictures("zoo", "uchOxFHxEaz69gYAwGb6UHOVHA_XsKULPPJGmZb9pb4").execute();
           assert response.body() != null;
           //response.body().getImages().forEach(System.out::println);
           System.out.println(response.body().getTotal());
          System.out.println(response.body().getTotalPages());
           System.out.println(response.body().getResults());
       } catch (IOException e) {
           e.printStackTrace();
       }
    }
}
