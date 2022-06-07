package com.company;


import com.company.Frame.MainFrame;
import com.company.retrofit.Controller;
import com.company.retrofit.model.Picture;

import java.util.List;

public class Main {
        static Controller controller = new Controller();
        static MainFrame frame = new MainFrame();
        public static int page = 1;

    public static void main(String[] args) {
        getPictures();
    }

    public static void showUrls(List<Picture> pictures){
        frame.drawLine(pictures);
        System.out.println("predano");
           }

    public static void getPictures(){
        if(page<=15)controller.getPictures(page);
    }


}
