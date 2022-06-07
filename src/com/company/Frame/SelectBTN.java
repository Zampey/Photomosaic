package com.company.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
