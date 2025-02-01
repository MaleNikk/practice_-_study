package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class AppDragDrop {

    private final ImageIcon icon;

    private final int width;

    private final int height;

    private Point point_1;

    private Point point_2;

    private final ClickListener clickListener;

    private final DragListener dragListener;

    private final JFrame frame;

    public AppDragDrop() {
        this.icon = new ImageIcon("src/main/resources/icons8-user-clock-100.png");
        this.width = icon.getIconWidth();
        this.height = icon.getIconHeight();
        this.point_1 = new Point(0,0);
        this.point_2 = new Point(0,0);
        this.clickListener = new ClickListener();
        this.dragListener = new DragListener();
        this.frame = initFrame();

    }

    private JFrame initFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("Drag and drop example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 700);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.GREEN);
        return frame;
    }

    private JPanel initPanel(){
        JPanel panel = new JPanel();
        return  panel;
    }

    private void paintComponent(Graphics graphics){
        frame.paintComponents(graphics);
        icon.paintIcon(frame,graphics,(int) point_1.getX(), (int) point_1.getY());
    }

    private class ClickListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);
            point_2 = e.getPoint();
        }
    }

    private class DragListener extends MouseMotionAdapter{
        public void mouseDragged(MouseEvent event){
            Point currentPoint = event.getPoint();

            point_1.translate(
                    (int) (currentPoint.getX() - point_2.getX()),
                    (int) (currentPoint.getY() - point_2.getY())
            );
            point_2 = currentPoint;
            frame.repaint();
        }
    }
}
