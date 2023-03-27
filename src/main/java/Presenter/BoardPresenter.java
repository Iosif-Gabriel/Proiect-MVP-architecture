package Presenter;

import Model.Cube;
import Model.Polyhedron;
import View.BoardInterface;
import View.BoardView;

import javax.swing.*;

public class BoardPresenter {
    private BoardInterface boardView;
    private Polyhedron cube;

    public BoardPresenter(BoardView boardView) {
        this.boardView = boardView;
        this.cube=new Cube();
    }

    public void drawShape(){
        JPanel panel=boardView.getInputPanel();
        int size=boardView.getDrawingSize();
        //int size2=boardView.getDrawingSize2();
        int x=boardView.getCoorX();
        int y=boardView.getCoorY();
        String color=boardView.getDrawingColor();
        String selectedp=boardView.getSelectedPolyhedron();
        int bigBase=boardView.getBigBase();
        int smallBase=boardView.getSmallBase();
        boardView.draw(selectedp,panel,0,size,color,x,y,smallBase,bigBase);

    }

    public void calculate(){
        int size=boardView.getDrawingSize();
        cube.getbaseArea(size);
        cube.getlateralArea(size);
        cube.getvolume(size);
    }
}
