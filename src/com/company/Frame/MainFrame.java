package com.company.Frame;

import com.company.Main;
import com.company.retrofit.model.Picture;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainFrame extends JFrame {
    private JFrame frame;
    private JPanel mosaicPanel;
    private SelectBTN btn = new SelectBTN();
    private MosaicPanel mPanel;

    public MainFrame(List<Image> images) throws HeadlessException {
        mPanel = new MosaicPanel(images);
        frame = new JFrame("Photomosaic");
        mosaicPanel = new JPanel();
        frameSetup();
        frame.add(mPanel.mosaicPanelSetup());
        frame.add(btn.getBtn());
        frame.setVisible(true);
        frame.validate();
    }

    public void frameSetup(){
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 950;
        int height = 600;
        frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        frame.setVisible(true);
    }



}
