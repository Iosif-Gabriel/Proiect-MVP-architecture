package Presenter;

import Model.DAO.UserDAO;
import Model.Tables.User;
import View.LogInInterface;
import View.LogInView;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogInPresenter {

    private UserDAO userDAO;
    private User user;
    private LogInInterface view;
    private String string;



    public LogInPresenter(LogInView view) {
        this.userDAO = new UserDAO();
        this.user=new User();
        this.view=view;
        string="";

    }

    public void logIn(String username, String password) {
        User user = userDAO.getUserName(username);
        if (user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {
            if (user.getUserType().equals("student")) {
                view.showStudentGUI();
            } else if(user.getUserType().equals("admin")){
                view.showAdminGUI();
            }
        } else {
            view.showErrorMessage("Invalid username or password");
        }
    }

}
