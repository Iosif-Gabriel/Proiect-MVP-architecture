package View.DrawShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TetrahedronDraw extends JPanel implements MouseListener {

    private int centerX, centerY, width, height,x,y;
    private String color1;


    public TetrahedronDraw(int centerX, int centerY, int width, int height,String color,int x,int y) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.width = width;
        this.height = height;
        this.color1=color;
        this.x=x;
        this.y=y;
        this.setPreferredSize(new Dimension(800, 800));
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int[] xPoints = { centerX, centerX + width/2, centerX, centerX - width/2 };
        int[] yPoints = { centerY - height/2, centerY, centerY + height/2, centerY };
        g.drawPolygon(xPoints, yPoints, 3);

        drawLines(g,x,y,color1);

    }

    public void drawLines(Graphics g,int x,int y,String color1){
        Color color = null;
        try {
            color = (Color)Color.class.getField(color1.toLowerCase()).get(null);
        } catch (Exception e) {
            color = Color.BLACK;
        }
        g.setColor(color);
        g.drawLine(x, y, centerX, centerY - height/2); // Top point
        g.drawLine(x, y, centerX + width/2, centerY); // Right point
        g.drawLine(x, y, centerX, centerY + height/2); // Bottom point
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

