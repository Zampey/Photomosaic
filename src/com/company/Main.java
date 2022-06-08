package com.company;


import com.company.Frame.MainFrame;
import com.company.retrofit.Controller;
import com.company.retrofit.model.Picture;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
        static Controller controller = new Controller();
        static MainFrame frame;
        public static int page = 1;
        public static List<Image> allImages = new ArrayList<>();

    public static void main(String[] args) {
        getPictures();
    }

    public static void calculateImages(List<Picture> pictureList){
        for (Picture picture :pictureList){
            URL url = null;

            try {
                url = new URL(picture.getUrls().getSmall());
                allImages.add(getScaledImage(ImageIO.read(url),10,10));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        page++;
        getPictures();
    }

    private static Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

       /* g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();*/
        return resizedImg;
    }

    public static void getPictures(){
        if(page<=2){
            controller.getPictures(page);
        }else{
            frame = new MainFrame(allImages);
            System.out.println(allImages.size());
        }
    }


}
