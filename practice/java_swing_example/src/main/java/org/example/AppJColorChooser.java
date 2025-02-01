package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AppJColorChooser implements ActionListener {

    private final JButton button;

    private final JLabel label;

    private final JFrame frame;

    private final JColorChooser colorChooser;

    public AppJColorChooser() {
        this.colorChooser = new JColorChooser();
        this.button = new JButton();
        this.label = new JLabel();
        this.frame = new JFrame();
        initButton();
        initLabel();
        initFrame();
    }

    private void initFrame(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test JColorChooser");
        frame.setFont(new Font("Frame font", Font.ITALIC,15));
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(512,512));
        frame.add(button);
        frame.add(label);
    }

    private void initLabel(){
        label.setBackground(Color.LIGHT_GRAY);
        label.setText("Text label");
        label.setOpaque(true);
        label.setSize(new Dimension(150,150));
        label.setFont(new Font("Label font",Font.BOLD,15));
    }

    private void initButton(){
        button.setSize(new Dimension(30,150));
        button.setText("Press");
        button.addActionListener(this);
    }

    private Color initColorChooser(){
      return JColorChooser.showDialog(colorChooser,"Pick a color ...", Color.GREEN);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(button,e.getSource())){
            label.setForeground(initColorChooser());
            label.setBackground(Color.WHITE);
        }
    }
}
