package org.example;

import javax.swing.*;
import java.awt.*;

public class AppBorderLayout {

    public AppBorderLayout() {
        initFrame(new Dimension(500,500),getBorderLayout(15,15),new Dimension(50,50));
    }

    private JFrame initFrame(Dimension dimension, BorderLayout borderLayout, Dimension dimensionPanel){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(dimension);
        frame.setLayout(borderLayout);
        Color[] colors = {Color.BLACK,Color.RED,Color.GREEN,Color.WHITE, Color.LIGHT_GRAY};
        String[] borders = {BorderLayout.NORTH,BorderLayout.CENTER,BorderLayout.EAST, BorderLayout.WEST, BorderLayout.SOUTH};
        for (int i = 0; i < 6; i++){
            JPanel panel = getPanel(dimensionPanel,colors[i]);
            frame.add(panel,borders[i]);
        }
        return frame;
    }

    private BorderLayout getBorderLayout(int hGap, int vGap ){
        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(hGap);
        borderLayout.setVgap(vGap);
        return borderLayout;
    }

    private JPanel getPanel(Dimension dimension, Color color){
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.setPreferredSize(dimension);
        return panel;
    }
}
