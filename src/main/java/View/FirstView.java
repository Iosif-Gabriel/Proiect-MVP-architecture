package View;

import Presenter.FirstPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FirstView extends JFrame implements ActionListener, FirstInterface {
    private JButton logInButton;
    private JPanel panel1;
    private JButton solButton;
    private JButton drawButton;
    private String fields;
    private final FirstPresenter firstPresenter;
    private final JButton saveButton;
    private JTextField field1,field2,field3,field4,field5;
    private  JDialog dialog;

    public FirstView(){
        setContentPane(panel1);
        setSize(new Dimension(500, 480));
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog=new JDialog();
        saveButton= new JButton("Save");
        this.solButton.addActionListener(this);
        this.logInButton.addActionListener(this);
        this.drawButton.addActionListener(this);
        fields="";
        firstPresenter=new FirstPresenter(this);
        getUserFields();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== drawButton){
            firstPresenter.displayBoard();
        }else if(e.getSource()==logInButton){
            firstPresenter.displayLogInGui();
        }else if(e.getSource()==solButton){
           firstPresenter.displaySolAccount();
        }
    }


    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

    @Override
    public void showBoard() {
        new BoardView();
        this.dispose();
    }

    @Override
    public void showLogInGUI() {
        this.dispose();
        new LogInView();
    }

    @Override
    public void solAccount() {
        dialog.setVisible(true);
        saveFields();
    }

    public void getUserFields() {
        // Create the dialog
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new GridLayout(6, 2));

        // Add the text fields
        dialog.add(new JLabel("UserName:"));
        field1 = new JTextField();
        dialog.add(field1);

        dialog.add(new JLabel("Password:"));
        field2 = new JTextField();
        dialog.add(field2);

        dialog.add(new JLabel("Last Name:"));
        field3 = new JTextField();
        dialog.add(field3);

        dialog.add(new JLabel("First Name:"));
        field4 = new JTextField();
        dialog.add(field4);

        dialog.add((new JLabel("Email:")));
        field5= new JTextField();
        dialog.add(field5);

        dialog.add(saveButton);
    }

    public void saveFields() {
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the save button action

                String value1 = field1.getText();
                String value2 = field2.getText();
                String value3 = field3.getText();
                String value4 = field4.getText();
                String value5 = field5.getText();

                try {
                    firstPresenter.writeFile(value1+","+value2+","+value3+","+value4+","+value5,"SolicitareCont.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                // Close the dialog
                dialog.dispose();
            }
        });

    }



}
