package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AppMouseListener implements MouseListener {

    private final JLabel label;

    public AppMouseListener() {
        label = initLabel();
        initFrame(label);
    }

    private void initFrame(JLabel label) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        //frame.addMouseListener(this);
        frame.add(label);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GREEN);

    }

    private JLabel initLabel() {
        JLabel label = new JLabel();
        ImageIcon imageIcon = new ImageIcon("src/main/resources/icons8-java-64.png");
        label.setBounds(50, 50, 180, 150);
        label.setBackground(Color.ORANGE);
        label.setVisible(true);
        label.setOpaque(true);
        label.setText("X = " + label.getX() + ", Y = " + label.getY());
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        label.setFont(new Font("Label font", Font.PLAIN,17));
        //label.setIcon(imageIcon);
        label.addMouseListener(this);
        return label;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("Click the mouse.");
        label.setBackground(Color.RED);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Pressed the mouse.");
        label.setBackground(Color.WHITE);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Released mouse on component.");
        label.setBackground(Color.BLACK);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Entered at the component.");
        label.setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("Exited mouse from component.");
        label.setBackground(Color.GREEN);
    }
}
