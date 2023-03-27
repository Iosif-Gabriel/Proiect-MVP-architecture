package View.DrawShapes;

import javax.swing.*;
import java.awt.*;

public class CubeDraw extends JPanel {

    private int size;
    private String color;

    private int x, y, shift;
    private Point[] cube1;
    private Point[] cube2;

    public CubeDraw(int newsize, String color) {
        this.size = newsize;
        this.color = color;
        this.x = 150;
        this.y = 150;
        this.shift = 100;
        this.cube1 = getCube1();
        this.cube2 = getCube2();
        this.setPreferredSize(new Dimension(800, 800));
    }

    private Point[] getCube1() {
        Point[] points = new Point[4];
        points[0] = new Point(x, y);
        points[1] = new Point(x + size, y);
        points[2] = new Point(x + size, y + size);
        points[3] = new Point(x, y + size);
        return points;
    }

    private Point[] getCube2() {
        int newX = x + shift;
        int newY = y + shift;
        Point[] points = new Point[4];
        points[0] = new Point(newX, newY);
        points[1] = new Point(newX + size, newY);
        points[2] = new Point(newX + size, newY + size);
        points[3] = new Point(newX, newY + size);
        return points;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color color = null;
        try {
            color = (Color)Color.class.getField(this.color.toLowerCase()).get(null);
        } catch (Exception e) {
            color = Color.BLACK;
        }
        g.setColor(color);
        g.drawRect(x, y, size, size);
        g.drawRect(x + shift, y + shift, size, size);
        // draw connecting lines
        for (int i = 0; i < 4; i++) {
            g.drawLine(cube1[i].x, cube1[i].y,
                    cube2[i].x, cube2[i].y);
        }
    }

}
