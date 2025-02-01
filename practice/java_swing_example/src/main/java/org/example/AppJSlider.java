package org.example;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class AppJSlider implements ChangeListener {


    private final JPanel panel;

    private final JLabel label;

    private final JSlider slider;

    public AppJSlider() {
        slider = initSlider();
        label = initLabel();
        panel = initPanel();
        initFrame();
    }

    private void initFrame(){
        JFrame frame = new JFrame();
        frame.setTitle("Test slider frame");
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
    }

    private JLabel initLabel(){
        JLabel jLabel = new JLabel();
        jLabel.setText("'C = " + slider.getValue());
        return jLabel;
    }

    private JPanel initPanel(){
        JPanel jPanel = new JPanel();
        jPanel.add(slider);
        jPanel.add(label);
        return jPanel;
    }

    private JSlider initSlider(){
        JSlider jSlider = new JSlider();
        jSlider.setPreferredSize(new Dimension(100,400));
        jSlider.setMaximum(100);
        jSlider.setMinimum(0);
        jSlider.setValue(50);
        jSlider.setPaintTicks(true);
        jSlider.setMinorTickSpacing(5);
        jSlider.setMajorTickSpacing(10);
        jSlider.setFont(new Font("Slider font", Font.ITALIC,15));
        jSlider.setPaintLabels(true);
        jSlider.setOrientation(SwingConstants.VERTICAL);
        jSlider.addChangeListener(this);
        return jSlider;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        label.setText("'C = " + slider.getValue());
    }
}
