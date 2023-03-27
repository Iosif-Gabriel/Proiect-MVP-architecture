package View.DrawShapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PyramidTrunkDraw extends JPanel implements MouseListener {
    private int centerX, centerY;
    private int smallBase,bigBase;
    private String color1;

    public PyramidTrunkDraw(int smallBase, int bigBase,String color1) {
        this.centerX=400;
        this.centerY=350;
        this.color1=color1;
        this.smallBase = smallBase;
        this.bigBase = bigBase;
        this.setPreferredSize(new Dimension(800, 800));
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawConnectedSquares(g,smallBase,bigBase,color1);
    }


    private int[] getX(int centerX,int width){
        return new int[]{ centerX, centerX + width/2, centerX, centerX - width/2 };

    }

    private int[] getY(int centerY,int height){
        return new int[]{ centerY - height/2, centerY, centerY + height/2, centerY };
    }



    public void drawConnectedSquares(Graphics g, int smallBase, int bigBase,String color1) {

        Color color = null;
        try {
            color = (Color)Color.class.getField(color1.toLowerCase()).get(null);
        } catch (Exception e) {
            color = Color.BLACK;
        }
        g.setColor(color);
        int[] smallSquareX = getX(400,smallBase);
        int[] smallSquareY = getY(350,smallBase);
        g.drawPolygon(smallSquareX, smallSquareY, 4);

        int[] bigSquareX = getX(430,bigBase);
        int[] bigSquareY = getY(200,bigBase);
        g.drawPolygon(bigSquareX, bigSquareY, 4);

        g.drawLine(smallSquareX[0], smallSquareY[0], bigSquareX[0], bigSquareY[0]);
        g.drawLine(smallSquareX[1], smallSquareY[1], bigSquareX[1], bigSquareY[1]);
        g.drawLine(smallSquareX[2], smallSquareY[2], bigSquareX[2], bigSquareY[2]);
        g.drawLine(smallSquareX[3], smallSquareY[3], bigSquareX[3], bigSquareY[3]);
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
