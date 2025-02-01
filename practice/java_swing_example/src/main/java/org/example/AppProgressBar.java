package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class AppProgressBar {

    private final JFrame frame;

    private final JProgressBar progressBar;

    public AppProgressBar() {
        progressBar = new JProgressBar();
        frame = new JFrame();
        initBar();
        initJFrame();
        fill();
    }

    private void initJFrame() {
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(512,512));
        frame.setLayout(new FlowLayout());
        frame.add(progressBar);
    }

    private void initBar(){
        progressBar.setMinimum(0);
        progressBar.setMaximum(1000);
        progressBar.setVisible(true);
        progressBar.setBounds(0,0,256,256);
        progressBar.setStringPainted(true);
        progressBar.setFont(new Font("Bar font", Font.BOLD,15));
        progressBar.setForeground(new Color(217,34,19));
        progressBar.setBackground(Color.YELLOW);
    }

    private void fill(){
        for (int i = 1000; i > 0; i--){
            progressBar.setValue(i);
            try {
                TimeUnit.NANOSECONDS.sleep(10000005);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        progressBar.setString("Complete!");
    }
}
