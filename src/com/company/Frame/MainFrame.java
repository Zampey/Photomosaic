package com.company.Frame;

import com.company.retrofit.model.Picture;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainFrame extends JFrame {
    private JFrame frame;


    public MainFrame() throws HeadlessException {
        frame = new JFrame("Photomosaic");
        frameSetup();

    }

    public void frameSetup(){
        frame.setLayout(new GridLayout());
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setSize(new Dimension(950,650));

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 950;
        int height = 650;
        frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        //frame.setVisible(true);
    }

    public void addPictures(List<Picture> pictureList){

        for (Picture picture :pictureList){

          URL url = null;
          try {
              url = new URL(picture.getUrls().getSmall());
                System.out.println(url);
              Image image = ImageIO.read(url);
              JLabel label = new JLabel(new ImageIcon(image));
              frame.add(label);
              frame.repaint();
          } catch (IOException e) {
              e.printStackTrace();
          }
        }


    }


}
