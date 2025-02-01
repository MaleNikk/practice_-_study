package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Objects;

public class AppMenuProgram implements ActionListener {

    private final JFrame frame;

    private final JMenuBar menuBar;

    private final String[] itemsName = {"Upload","Download","Save","Exit"};

    private final String[] commands = {"File","Properties","Help"};

    private final HashMap<String,JMenuItem> items;

    public AppMenuProgram() {
        items = new HashMap<>();
        menuBar = new JMenuBar();
        frame = new JFrame();
        initItems();
        initMenuBar();
        initFrame();
    }

    private void initFrame(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(512,512));
        frame.setTitle("Test menu bar of frame");
        frame.setJMenuBar(menuBar);
    }

    private void initMenuBar(){
        for (String command : commands){
            JMenu menu = new JMenu(command);
            if (Objects.equals(command,commands[0])){
                for (JMenuItem item : items.values()){
                    item.addActionListener(this);
                    menu.add(item);
                }
            }
            menuBar.add(menu);
        }
    }

    private void initItems(){
        for (String item : itemsName){
            JMenuItem jMenuItem = new JMenuItem(item);
            jMenuItem.setName(item);
            items.put(item,jMenuItem);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        System.out.println("Your choice: " + item.getName());
        if (Objects.equals(item.getName(),itemsName[3])){
            System.exit(0);
        }
    }
}
