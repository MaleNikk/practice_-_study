package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AppJTextField extends JFrame implements ActionListener {

    JTextField textField;

    JButton button;

    public AppJTextField() {
        textField = getTextField();
        button = getButton();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.add(button);
        this.add(textField);
        this.pack();
    }


    public JButton getButton() {
        JButton button = new JButton();
        button.setText("Confirm.");
        button.addActionListener(this);
        return button;
    }

    public JTextField getTextField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(550, 35));
        textField.setFont(new Font("New font.", Font.ITALIC, 30));
        textField.setForeground(new Color(15, 75, 35));
        textField.setCaretColor(Color.GREEN);
        textField.setText("Write anything!");
        return textField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getSource(), button)) {
            System.out.println("Input text: " + textField.getText());
            button.setText("Stop write!");
            button.setEnabled(false);
            textField.setEditable(false);

        }
    }
}
