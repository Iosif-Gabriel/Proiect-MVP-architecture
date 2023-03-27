package View.DrawShapes;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class PyramidDraw extends JPanel implements MouseListener {
        private int centerX, centerY, width, height,x,y,size;
        private String color1;


        public PyramidDraw(int size,String color,int x,int y) {
                this.size=size;
                this.centerX = 400;
                this.centerY = 350;
                this.width = size+200;
                this.height = size;
                this.color1=color;
                this.x=x;
                this.y=y;
                addMouseListener(this);
                this.setPreferredSize(new Dimension(800, 800));
        }

        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int[] xPoints = { centerX, centerX + width/2, centerX, centerX - width/2 };
                int[] yPoints = { centerY - height/2, centerY, centerY + height/2, centerY };
                g.drawPolygon(xPoints, yPoints, 4);
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
                g.drawLine(x, y, centerX - width/2, centerY); // Left point
        }

        public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                JOptionPane.showMessageDialog(null,"Clicked at (" + x + ", " + y + ")");
        }

        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}

}
