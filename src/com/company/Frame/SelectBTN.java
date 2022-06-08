package com.company.Frame;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SelectBTN extends JButton implements ActionListener {
    private JButton btn;

    public SelectBTN() {
        btn = new JButton();
    }

    public JButton btnSetup(){
        btn.setText("Vybrat soubor");
        btn.setBounds(75,75,130,30);
        return btn;
    }

    public static File chooseFile(){
        File file = null;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        fileChooser.setFileFilter(filter);

        int chooserResponse = fileChooser.showOpenDialog(null);

        if (chooserResponse == JFileChooser.APPROVE_OPTION){
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        }else{
            System.out.println("neplatný soubor");
        }
        return file;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        chooseFile();
    }
}
