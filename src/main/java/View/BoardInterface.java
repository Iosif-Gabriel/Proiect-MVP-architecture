package View;

import javax.swing.*;

public interface BoardInterface {
    int getDrawingSize();
    int getDrawingSize2();
    int getCoorX();
    int getCoorY();
    String getDrawingColor();
    void draw(String selectedPolyhedron, JPanel panel, int size,int size2, String color, int x, int y,int smallBase,int bigBase);
    JPanel getInputPanel();
    String getSelectedPolyhedron();
    int getSmallBase();
    int getBigBase();
    //void showCalculations(String selectedPoly,String cal);
}
