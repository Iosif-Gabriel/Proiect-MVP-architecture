package View.DrawShapes;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class PrismaDraw extends JPanel implements MouseListener {
    private String color1;
    private int size;

    public PrismaDraw(String color,int size) {
        this.color1=color;
        this.size=size;
        this.addMouseListener(this);
        this.setPreferredSize(new Dimension(800, 800));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x1 = 200;
        int y1 = 200;

        int x2 = 300;
        int y2 = 100;

        int x3 = 550;
        int y3 = 200;

        drawTriange(g,x1,x2,x3,y1,y2,y3,color1);
        drawTriange(g,x1,x2,x3,y1+size,y2+size,y3+size,color1);
        g.drawLine(x1,y1,x1,y1+size);
        g.drawLine(x2,y2,x2,y2+size);
        g.drawLine(x3,y3,x3,y3+size);


    }

    void drawTriange(Graphics g,int x1,int x2,int x3,int y1,int y2, int y3,String color1){
        Color color = null;
        try {
            color = (Color)Color.class.getField(this.color1.toLowerCase()).get(null);
        } catch (Exception e) {
            color = Color.BLACK;
        }
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
        g.drawLine(x2, y2, x3, y3);
        g.drawLine(x3, y3, x1, y1);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        JOptionPane.showMessageDialog(null,"Clicked at (" + x + ", " + y + ")");
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
