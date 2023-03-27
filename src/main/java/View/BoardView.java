package View;

import Presenter.BoardPresenter;
import View.DrawShapes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class BoardView extends JFrame implements ActionListener,BoardInterface {

    private JPanel mainPanel, inputPanel, drawPanel;
    private JTextField sizeField, biBaseField, smallBaseField, pointField,size2Field;
    private JComboBox<String> colorBox;
    private JButton drawButton, backButton,calculeButton;
    private JComboBox<String> polyhedronBox ,calculeBox;
    private BoardPresenter boardPresenter;

    public BoardView() {
        // Set up the frame
        setTitle("Drawing App");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 600));
        boardPresenter=new BoardPresenter(this);

        // Create the main panel and set its layout
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Create the input panel and add components to it
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 2, 10, 10));
        inputPanel.setPreferredSize(new Dimension(200, 0));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 11, 10, 10));

        JLabel sizeLabel = new JLabel("Size:");
        sizeField = new JTextField(5);
        inputPanel.add(sizeLabel);
        inputPanel.add(sizeField);

      /*  JLabel secondLabel = new JLabel("Size2:");
        size2Field = new JTextField(5);
        inputPanel.add(secondLabel);
        inputPanel.add(size2Field);*/

        JLabel bigBaseLabel = new JLabel("Small base:");
        biBaseField = new JTextField(5);
        inputPanel.add(bigBaseLabel);
        inputPanel.add(biBaseField);

        JLabel smallBase = new JLabel("Big base:");
        smallBaseField = new JTextField(5);
        inputPanel.add(smallBase);
        inputPanel.add(smallBaseField);

        JLabel zLabel = new JLabel("Point:");
        pointField = new JTextField(5);
        inputPanel.add(zLabel);
        inputPanel.add(pointField);

        String[] colors = {"Red", "Green", "Blue","Black","Yellow"};
        colorBox = new JComboBox<>(colors);
        inputPanel.add(colorBox);

        String[] polyhedron={"Cube","Piramida","Paralelipiped","Tetraedru","Prisma","Paralelipiped","Trunchi de Piramida"};
        polyhedronBox=new JComboBox<>(polyhedron);
        inputPanel.add(polyhedronBox);

        String[] calcule={"Aria Laterala","Aria bazei","Aria totala","Volum"};
        calculeBox=new JComboBox<>(calcule);
        inputPanel.add(calculeBox);

        drawButton = new JButton("Presenter");
        drawButton.addActionListener(this);
        inputPanel.add(drawButton);

        backButton=new JButton("Back");
        backButton.addActionListener(this);
        inputPanel.add(backButton);

        calculeButton=new JButton("Calculeaza");
        calculeButton.addActionListener(this);
        inputPanel.add(calculeButton);

        // Create the drawing panel and add it to the main panel
        drawPanel = new JPanel();
        drawPanel.setBackground(Color.WHITE);
        mainPanel.add(drawPanel, BorderLayout.CENTER);

        // Add the input panel to the main panel
        mainPanel.add(inputPanel, BorderLayout.WEST);

        // Add the main panel to the frame and show it
        add(mainPanel);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == drawButton) {
            boardPresenter.drawShape();
            }
        else if(e.getSource() == backButton){
            this.dispose();
            new FirstView();
        }else if(e.getSource()==calculeButton){
            boardPresenter.calculate();
        }


    }

    @Override
    public int getDrawingSize() {
        if(sizeField.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(sizeField.getText());
    }

    @Override
    public int getDrawingSize2() {
        if(size2Field.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(size2Field.getText());
    }

    @Override
    public int getCoorX() {

        String[] coor= pointField.getText().split(",");
        if(coor.length>1){
            return Integer.parseInt(coor[0]);
        }
        return 0;
    }

    @Override
    public int getCoorY() {
        String[] coor= pointField.getText().split(",");
        if(coor.length>1){
            return Integer.parseInt(coor[1]);
        }
        return 0;
    }

    @Override
    public void draw(String selectedPolyhedron, JPanel panel,int size2, int size, String color, int x, int y,int smallBase,int bigBase) {

        switch (selectedPolyhedron) {
            case "Piramida" -> panel = new PyramidDraw(size, color, x, y);
            case "Cube" -> panel = new CubeDraw(size, color);
            case "Tetraedru" -> panel = new TetrahedronDraw(350, 350, 300 + size, 100 + size, color, x, y);
            case "Prisma" -> panel= new PrismaDraw(color,size);
            case "Paralelipiped" -> panel =new ParalelipipedDraw(size,size2,color);
            case "Trunchi de Piramida" -> panel=new PyramidTrunkDraw(smallBase,bigBase,color);
        }
        if (panel != null) {
            drawPanel.removeAll();
            drawPanel.add(panel);
            drawPanel.repaint();
            drawPanel.revalidate();
        }

    }


    public String getSelectedPolyhedron(){
       return  Objects.requireNonNull(polyhedronBox.getSelectedItem()).toString();
    }

    @Override
    public int getSmallBase() {
        if(smallBaseField.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(smallBaseField.getText());
    }

    @Override
    public int getBigBase() {
        if(biBaseField.getText().isEmpty()){
            return 0;
        }
        return Integer.parseInt(biBaseField.getText());
    }

    public JPanel getInputPanel(){
        return inputPanel;
    }

    public String getDrawingColor(){
        return Objects.requireNonNull(colorBox.getSelectedItem()).toString();
    }


}
