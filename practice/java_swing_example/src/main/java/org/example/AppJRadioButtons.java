package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class AppJRadioButtons implements ActionListener {

    private final String[] names = {"pizza", "hamburger", "hotDog", "coffee"};

    private final HashMap<String, JRadioButton> buttons = initButtons(names);

    public AppJRadioButtons() {
        initButtonGroup();
        initFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JRadioButton button = (JRadioButton) e.getSource();
        System.out.println("Your choice: " + button.getText());
    }

    private void initFrame() {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (JRadioButton button : buttons.values()) {
            frame.add(button);
        }
        frame.pack();
    }

    private JRadioButton initRadioButton(String name) {
        JRadioButton radioButton = new JRadioButton();
        radioButton.setText(name);
        radioButton.addActionListener(this);
        return radioButton;
    }

    private void initButtonGroup() {
        ButtonGroup group = new ButtonGroup();
        for (JRadioButton button : buttons.values()) {
            group.add(button);
        }
    }

    private HashMap<String, JRadioButton> initButtons(String[] names) {
        HashMap<String, JRadioButton> buttons = new HashMap<>();
        for (String name : names) {
            buttons.put(name, initRadioButton(name));
        }
        return buttons;
    }
}
