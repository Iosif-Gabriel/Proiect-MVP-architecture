package View;

import Presenter.LogInPresenter;
import Presenter.StudentPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInView extends JFrame implements ActionListener,LogInInterface {
    private JButton logInButton;
    private JPanel panel1;
    private JTextField passwordField;
    private JTextField usernameField;
    private JButton backButton;
    private JLabel passwordLabel;
    private JLabel usernameLabel;
    private LogInPresenter logInPresenter;
    private String userName;

    public LogInView() {
        setContentPane(panel1);
        setSize(new Dimension(500, 480));
        setVisible(true);
        backButton.addActionListener(this);
        logInButton.addActionListener(this);
        this.logInPresenter=new LogInPresenter(this);
        userName="";

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            this.dispose();
            new FirstView();
        }
        if(e.getSource()==logInButton){
            userName=getUsername();
            String password=getPassword();
            logInPresenter.logIn(userName, password);
        }
    }

    @Override
    public String getUsername() {
        return usernameField.getText();
    }

    @Override
    public String getPassword() {
        return passwordField.getText();
    }

    @Override
    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

    @Override
    public void showStudentGUI() {
        new StudentView();
        this.dispose();
    }

    @Override
    public void showAdminGUI() {
        new AdminView();
        this.dispose();
    }

}
