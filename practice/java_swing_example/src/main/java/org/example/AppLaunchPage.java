package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AppLaunchPage implements ActionListener {

    private final JButton button;

    private final JFrame frame;

    public AppLaunchPage() {
        button = getButton();
        frame = initFrame(button);
    }

    private JFrame initFrame(JButton button){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.add(button);
        return frame;
    }

    private JButton getButton(){
        JButton button = new JButton();
        button.setText("Check button.");
        button.setBounds(100,160,200,40);
        button.setVerticalAlignment(JButton.CENTER);
        button.addActionListener(this);
        return button;
    }

    private JLabel getLabel(){
        JLabel label = new JLabel();
        label.setText("Text for label.");
        label.setBounds(50,50,350,50);
        label.setFont(new Font("Some font",Font.ITALIC,30));
        label.setVerticalAlignment(JLabel.CENTER);
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getSource(),button)){
            new NewWindow();
            frame.dispose();
        }
    }

    private class NewWindow {
        public NewWindow() {
            start();
        }

        private void start(){
            System.out.println("Init new Window!");
            JFrame frame = initFrame(button);
            frame.add(getLabel());
        }
    }
}
