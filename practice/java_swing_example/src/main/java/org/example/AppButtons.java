package org.example;

import javax.swing.*;
import java.awt.*;

public class AppButtons {

    private final JFrame frame;

    private final JPanel panel;

    private final String[] buttonsName = {
            "Start indexing","Stop indexing", "Statistics", "Search", "Stop search", "Add links"};

        public AppButtons() {
            this.panel = new JPanel();
            this.frame = new JFrame();
            initPanel();
            initFrame();
    }

    private void initFrame(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.LEFT,9,9));//set position on frame
        frame.setTitle("Searching engine");
        frame.setSize(new Dimension(512,512));
        frame.add(panel);
        //frame.pack();
    }

    private void initPanel(){
        panel.setPreferredSize(new Dimension(128,448));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        panel.setLayout(new GridLayout(buttonsName.length,1));//set position on panel
        for (String button : buttonsName){
            JButton jButton = new JButton(button);
            jButton.setSize(new Dimension(16,128));
            jButton.setFocusable(true);
            panel.add(jButton);
        }
    }
}
