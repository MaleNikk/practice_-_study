package org.example;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppFrame extends JFrame implements ActionListener {

    private final String iconPathFile;

    private final int x;

    private final int y;

    private final int weight;

    private final int height;

    private final JButton jButton;

    private final JLabel jLabel;

    public AppFrame(String iconPathFile) throws HeadlessException {
        this.iconPathFile = iconPathFile;
        x = 50;
        y = 50;
        weight = 250;
        height = 250;
        jButton = getJButton();
        jLabel = getJLabel(getIcon(getIconPathFile()),getBorder());
        initFrame(jLabel);
    }

    private JLabel getJLabel(ImageIcon imageIcon, Border border) {
        JLabel jLabel = new JLabel();// create a label
        jLabel.setText("Male_Nik start doing!"); // set text of label
        jLabel.setIcon(imageIcon); // set image icon
        jLabel.setVisible(true);
        jLabel.setHorizontalTextPosition(JLabel.CENTER); // set text LEFT,CENTER,RIGHT og image icon
        jLabel.setVerticalTextPosition(JLabel.TOP); // set text TOP, CENTER, BOTTOM of image icon
        jLabel.setForeground(Color.GRAY); // set fon color of text
        jLabel.setFont(new Font("MV Boli", Font.PLAIN, 25)); // set font of text
        jLabel.setIconTextGap(50); // set gap of text image
        jLabel.setBackground(Color.GREEN); // set background color
        jLabel.setOpaque(true); // display background color ON, OFF
        jLabel.setBorder(border); // sets border of label (not image + text)
        jLabel.setVerticalAlignment(JLabel.CENTER); // set vertical position of icon+text within label
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        jLabel.setBounds(125, 125, 350, 350);// set x,y position withing frame as well a dimensions
        return jLabel;
    }

    private void initFrame(JLabel jLabel) {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("Title for frame right here.");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit out of application
        myFrame.setSize(900, 900);
        myFrame.setLayout(null);
        myFrame.setVisible(true);
        myFrame.add(jButton);
        myFrame.add(jLabel);
        myFrame.getContentPane().setBackground(new Color(195, 195, 195));//change color of background
        myFrame.add(getJPanel(Color.ORANGE,x,y,weight,height));
        myFrame.add(getJPanel(Color.GRAY,x,x+weight,weight,height));
        myFrame.add(getJPanel(Color.DARK_GRAY,y+height,y,weight,height));
        myFrame.add(getJPanel(Color.RED,x+weight,y+height,weight,height));
        //myFrame.pack();//set size label and window to one size
    }

    private JButton getJButton(){
        JButton jButton = new JButton();
        jButton.setBounds(x*4,y*15,x*4,y*2);
        jButton.setVisible(true);
        jButton.setText("Check button");
        jButton.setFocusable(false);
        jButton.setIcon(getIcon("src/main/resources/icons8-java-64.png"));
        jButton.setHorizontalTextPosition(JButton.CENTER);
        jButton.setVerticalTextPosition(JButton.BOTTOM);
        jButton.setFont(new Font("Comic Sans", Font.BOLD, 20));
        jButton.setIconTextGap(-3);// set distance icon ~ text
        jButton.setForeground(Color.ORANGE);//set button text color
        jButton.setBackground(Color.YELLOW);// set background color of all button
        jButton.setBorder(BorderFactory.createRaisedBevelBorder());// set visible effect button
        jButton.addActionListener(e ->System.out.println("Lambda expression! Button work!"));
        jButton.addActionListener(this);
        return jButton;
    }

    private ImageIcon getIcon(String pathFile) {
        return new ImageIcon(pathFile);
    }

    private Border getBorder() {
        return BorderFactory.createLineBorder(Color.ORANGE, 25);
    }

    private JPanel getJPanel(Color color, int x, int y, int width, int height){
        JPanel jPanel = new JPanel();
        jPanel.setBackground(color);
        jPanel.setBounds(x,y,width,height);
        return jPanel;
    }

    private String getIconPathFile() {
        return iconPathFile;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(jButton)){
            System.out.println("Classic listener work!");
            jButton.setEnabled(false);//make work one
            jLabel.setVisible(false);
        }
    }
}

