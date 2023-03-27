package View;

import Presenter.StudentPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentView extends JFrame implements ActionListener, StudentInterface {
    private JButton backButton;
    private JPanel panel1;
    private JButton submitButton;
    private JButton nextButton;
    private JButton testButton;
    private JTextField ansField;
    private JLabel answerLabel;
    private JPanel testPanel;
    private JLabel textLabel;
    private StudentPresenter studentPresenter;

    public StudentView() {
        setContentPane(panel1);
        setSize(new Dimension(600, 480));
        setVisible(true);
        studentPresenter=new StudentPresenter(this);
        backButton.addActionListener(this);
        testButton.addActionListener(this);
        nextButton.addActionListener(this);
        submitButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            studentPresenter.backButton();
        }
        if(e.getSource()==testButton){
            studentPresenter.startTest();
            studentPresenter.showMessage();
        }
        if(e.getSource()==nextButton){
            textLabel.setText(studentPresenter.getNextQuestion());
        }else if (e.getSource()==submitButton){
            studentPresenter.submitAnswer();
        }

    }

    @Override
    public void backButton() {
        this.dispose();
        new FirstView();
    }

    @Override
    public void showMessage(String Message) {
        JOptionPane.showMessageDialog(this,Message);
    }

    @Override
    public void showPunctaj(String message) {
        JOptionPane.showMessageDialog(null,message);
    }

    @Override
    public String getAnswer() {
        return ansField.getText();
    }

}
