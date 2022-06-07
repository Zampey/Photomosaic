package com.company.Frame;

import com.company.Main;
import com.company.retrofit.model.Picture;
import lombok.Getter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class MainFrame extends JFrame {
    private JFrame frame;
    private JPanel mosaicPanel;
    private SelectBTN btn = new SelectBTN();

    public MainFrame() throws HeadlessException {
        frame = new JFrame("Photomosaic");
        mosaicPanel = new JPanel();
        frameSetup();
        mosaicPanelSetup();
        frame.add(btn.btnSetup());
    }

    public void frameSetup(){
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 950;
        int height = 550;
        frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        frame.setVisible(true);
    }

    public void mosaicPanelSetup(){
        FlowLayout fl = new FlowLayout();
        fl.setHgap(0);
        fl.setVgap(0);

        mosaicPanel.setPreferredSize(new Dimension(300,500));
        mosaicPanel.setBorder(BorderFactory. createLineBorder(Color. black,5));
        mosaicPanel.setLayout (fl);
        mosaicPanel.setBounds(950/2-150,275-250,300,500);
    }

    public void drawLine(List<Picture> pictureList){
        for (Picture picture :pictureList){
          URL url = null;

          try {
              url = new URL(picture.getUrls().getSmall());
                System.out.println(url);
              Image image = ImageIO.read(url);
              JLabel label = new JLabel(new ImageIcon(getScaledImage(image,10, 10)));
              mosaicPanel.add(label);
          } catch (IOException e) {
              e.printStackTrace();
          }
            frame.setVisible(true);
        }
        frame.add(mosaicPanel);
        Main.page++;
        Main.getPictures();
    }

    private Image getScaledImage(Image srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

}
