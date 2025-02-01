package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AppKeyListener implements KeyListener {

    private final JLabel label;

    public AppKeyListener() {
        label = getLabel();
        initFrame(label);
    }

    private void initFrame(JLabel label) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.addKeyListener(this);
        frame.add(label);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GREEN);

    }

    private JLabel getLabel() {
        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src/main/resources/icons8-java-64.png");
        label.setBounds(50, 50, 180, 150);
        label.setVisible(true);
        label.setOpaque(true);
        label.setText("X = " + label.getX() + ", Y = " + label.getY());
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        label.setFont(new Font("Label font", Font.PLAIN,17));
        label.setIcon(imageIcon);
        return label;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a':
                //'a' - 65
                label.setLocation(label.getX() - 5, label.getY());
                label.setText("X = " + label.getX() + ", Y = " + label.getY());
                break;
            case 'w':
                //'w' - 87
                label.setLocation(label.getX(),label.getY() - 5);
                label.setText("X = " + label.getX() + ", Y = " + label.getY());
                break;
            case 's':
                //'s' - 83
                label.setLocation(label.getX(),label.getY() + 5);
                label.setText("X = " + label.getX() + ", Y = " + label.getY());
                break;
            case 'd':
                //'d' - 68
                label.setLocation(label.getX() + 5,label.getY());
                label.setText("X = " + label.getX() + ", Y = " + label.getY());
                break;
            default:
                label.setLocation(0,0);
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 65:
                //'a' - 65
                label.setLocation(label.getX() - 5, label.getY());
                break;
            case 87:
                //'w' - 87
                label.setLocation(label.getX(),label.getY() - 5);
                break;
            case 83:
                //'s' - 83
                label.setLocation(label.getX(),label.getY() + 5);
                break;
            case 68:
                //'d' - 68
                label.setLocation(label.getX() + 5,label.getY());
                break;
            default:
                label.setLocation(0,0);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("Key char released: " + e.getKeyChar());
        System.out.println("Key code released: " + e.getKeyCode());
    }
}
