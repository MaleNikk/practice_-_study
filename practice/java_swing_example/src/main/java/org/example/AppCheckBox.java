package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class AppCheckBox extends JFrame implements ActionListener {

    private final JButton button;

    private final JCheckBox checkBox;

    private final ImageIcon yes;

    private final ImageIcon no;



    public AppCheckBox() throws HeadlessException {
        this.button = getButton();
        this.checkBox = getCheckBox();
        this.yes = new ImageIcon("src/main/resources/icons8-java-64.png");
        this.no = new ImageIcon("src/main/resources/icons8-user-clock-100.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.add(button);
        this.add(checkBox);
        this.pack();
    }

    private JCheckBox getCheckBox(){
        JCheckBox checkBox = new JCheckBox();
        checkBox.setText("This is test check box!");
        checkBox.setFocusable(false);
        checkBox.setFont(new Font("Init font", Font.PLAIN,25));
        checkBox.setIcon(yes);
        checkBox.setSelectedIcon(no);
        return checkBox;
    }

    private JButton getButton(){
        JButton button = new JButton();
        button.setText("Approve!");
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getSource(),button)){
            System.out.println(checkBox.isSelected());
        }
    }
}
