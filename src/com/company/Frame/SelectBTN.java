package com.company.Frame;

import com.company.ColorCalculation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SelectBTN extends JButton {
    private JButton btn;
    private int width = 0;
    private int height = 0;

    public SelectBTN() {
        btn = btnSetup(new JButton());
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColorCalculation.averageColor(convertToImage(chooseFile()),0,0,width,height);
            }
        });
    }

    public JButton btnSetup(JButton btn) {
        btn.setText("Vybrat soubor");
        btn.setBounds(75, 75, 130, 30);
        return btn;
    }

    public static File chooseFile() {
        File file = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("IMAGE", "jpg", "png");
        fileChooser.setFileFilter(filter);

        int chooserResponse = fileChooser.showOpenDialog(null);

        if (chooserResponse == JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        } else {
            System.out.println("neplatný soubor");
        }
        return file;
    }

    public BufferedImage convertToImage(File file){
        try {
            BufferedImage image = ImageIO.read(file);
            width = image.getWidth();
            height = image.getHeight();
            return image;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public JButton getBtn() {
        return btn;
    }
}