package View.DrawShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ParalelipipedDraw extends JPanel implements MouseListener {

    private int size;
    private int size2;
    private String color1;

    public ParalelipipedDraw(int newsize,int size2, String color1) {
        this.size = newsize;
        this.size2=size2;
        this.color1 = color1;
        this.setPreferredSize(new Dimension(800, 800));
        this.addMouseListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color color = null;
        try {
            color = (Color)Color.class.getField(this.color1.toLowerCase()).get(null);
        } catch (Exception e) {
            color = Color.BLACK;
        }
        g.setColor(color);
        g.drawRect(150, 150, size, size+150);
        g.drawRect(270, 20, size, size+150);
        g.drawLine(150, 150, 270, 20);
        g.drawLine(150, size+300, 270, size+170);
        g.drawLine(150+size, 150, 270+size, 20);
        g.drawLine(150+size, size+300, 270+size, size+170);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        JOptionPane.showMessageDialog(this,"X"+x+" "+"Y"+y);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
