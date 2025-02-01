package org.example;

import javax.swing.*;
import java.awt.*;

public class AppGridLayout {
    public AppGridLayout() {
        initFrame();
    }

    private void initFrame(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(500,500));
        frame.setLayout(new GridLayout(1,7,1,1));//set size button
        int countButton = 0;
        do {
            JButton button = new JButton(String.valueOf(countButton));
            frame.add(button);
            countButton++;
        } while (countButton < 10);

    }
}
