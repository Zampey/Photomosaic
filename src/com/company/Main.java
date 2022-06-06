package com.company;


import com.company.Frame.MainFrame;
import com.company.retrofit.Controller;
import com.company.retrofit.PhotoService;
import com.company.retrofit.ApiHolder;
import com.company.retrofit.model.Picture;
import com.company.retrofit.model.PicturesCollection;
import retrofit2.Retrofit;

import javax.swing.*;
import java.util.List;

public class Main {
        static Controller CONTROLLER = new Controller();
        static MainFrame FRAME = new MainFrame();

    public static void main(String[] args) {

        CONTROLLER.getPictures();



    }

    public static void showUrls(List<Picture> pictures){
        FRAME.addPictures(pictures);
        System.out.println("predano");
           }



}
