package com.company.Frame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MosaicPanel extends JPanel {

    private List<Image> images = new ArrayList<>();

    public MosaicPanel(List<Image> images) throws HeadlessException {
        this.images = images;
    }

    public JPanel mosaicPanelSetup(){
        JPanel mosaicPanel = new JPanel();
        FlowLayout fl = new FlowLayout();
        fl.setHgap(0);
        fl.setVgap(0);

        mosaicPanel.setPreferredSize(new Dimension(300,500));
        mosaicPanel.setBorder(BorderFactory. createLineBorder(Color. black,5));
        mosaicPanel.setLayout (fl);
        mosaicPanel.setBounds(950/2-150,275-250,300,500);
        mosaicPanel.setVisible(true);
        return mosaicPanel;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        int y = 0;

        for (int i = 0; i < images.size(); i++) {
            g.drawImage(images.get(i), 0, 0, null);
            x+=10;
            this.revalidate();
        }
    }
}
