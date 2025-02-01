package org.example;

import javax.swing.*;
import java.awt.*;

public class AppJLayerPane {
    public AppJLayerPane() {
        initFrame(getJLayerPane());
    }

    private void initFrame(JLayeredPane layeredPane) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500, 500));
        frame.setLayout(null);
        Color[] colors = {Color.BLACK, Color.GREEN, Color.RED, Color.LIGHT_GRAY, Color.CYAN, Color.MAGENTA, Color.ORANGE};
        Integer[] layeredPanes = {
                JLayeredPane.DEFAULT_LAYER,
                JLayeredPane.DRAG_LAYER,
                JLayeredPane.MODAL_LAYER,
                JLayeredPane.PALETTE_LAYER,
                JLayeredPane.FRAME_CONTENT_LAYER,
                JLayeredPane.POPUP_LAYER,
                500};
        int[] size = {50, 50, 150, 150};
        int countLabel = 0;
        do {
            layeredPane.add(
                    getJLabel(colors[countLabel], size[0] * countLabel, size[1] * countLabel, size[2], size[3]),
                    layeredPanes[countLabel]);
            countLabel++;
        } while (countLabel < 7);
        frame.add(layeredPane);
    }

    private JLayeredPane getJLayerPane() {
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, 500, 500);
        return layeredPane;
    }

    private JLabel getJLabel(Color color, int x, int y, int width, int height) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        label.setBackground(color);
        label.setBounds(x, y, width, height);
        return label;
    }
}
