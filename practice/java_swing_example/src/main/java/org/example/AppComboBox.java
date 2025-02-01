package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppComboBox implements ActionListener {

    private final String[] animals = {"dog","cat","bird"};

    private final int[] digits = {125,235,345};

    public AppComboBox() {
        initFrame("Test combo box.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
        System.out.println("Your choice: " + comboBox.getSelectedItem() + "\n" +
                "\t\t" + "Index select: " + comboBox.getSelectedIndex());
    }

    private void initFrame(String title){
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title.toUpperCase());
        frame.add(initComboBoxString());
        frame.add(initComboBoxInteger());
        frame.pack();
    }

    private JComboBox<String> initComboBoxString(){
        JComboBox<String> comboBox = new JComboBox<>();
        for (String animal : animals){
            comboBox.addItem(animal);
        }
        comboBox.addActionListener(this);
        return comboBox;
    }

    private JComboBox<Integer> initComboBoxInteger(){
        JComboBox<Integer> comboBox = new JComboBox<>();
        for (int digit : digits){
            comboBox.addItem(digit);
        }
        comboBox.addActionListener(this);
        return comboBox;
    }
}
