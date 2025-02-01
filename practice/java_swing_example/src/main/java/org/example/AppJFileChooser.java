package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Objects;

public class AppJFileChooser implements ActionListener {

    private final JFrame frame;

    private final JButton button;

    private final JFileChooser fileChooser;

    public AppJFileChooser() {
        this.button = new JButton();
        this.frame = new JFrame();
        this.fileChooser = new JFileChooser();
        initButton();
        initFrame();
    }

    private void initFrame(){
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setTitle("Test file chooser");
        frame.add(button);
        frame.pack();
    }

    private void initButton(){
        button.setText("Select file");
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = (JButton) e.getSource();
        if (Objects.equals(button,jButton)){
            fileChooser.setCurrentDirectory(
                    new File("B:/develop/DevelopCode/library_component_code/java_swing_example/src/main/resources"));
            int response = fileChooser.showOpenDialog(null);
            int saveResponse = fileChooser.showSaveDialog(null);
            if (Objects.equals(response,JFileChooser.APPROVE_OPTION)){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }

            if (Objects.equals(saveResponse,JFileChooser.APPROVE_OPTION)){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
            }
        }
    }
}
