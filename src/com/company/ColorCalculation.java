package com.company;

import lombok.AllArgsConstructor;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

@AllArgsConstructor
public class ColorCalculation {

    public static void averageColor(BufferedImage bi, int x0, int y0, int w,
                                     int h) {
        int x1 = x0 + w;
        int y1 = y0 + h;
        long sumr = 0, sumg = 0, sumb = 0;
        for (int x = x0; x < x1; x++) {
            for (int y = y0; y < y1; y++) {
                Color pixel = new Color(bi.getRGB(x, y));
                sumr += pixel.getRed();
                sumg += pixel.getGreen();
                sumb += pixel.getBlue();
            }
        }
        int num = w * h;
        System.out.println(num);
        System.out.println(sumr/num);
        System.out.println(sumg/num);
        System.out.println(sumb/num);

        //System.out.println(new Color(sumr / num, sumg / num, sumb / num));
        // new Color(sumr / num, sumg / num, sumb / num);
    }

}
