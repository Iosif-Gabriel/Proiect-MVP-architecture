package Presenter;

import Model.DAO.UserDAO;
import Model.RandomID;
import Model.Tables.User;
import View.AdminInterface;
import View.AdminView;

import java.util.List;

public class AdminPresenter {
    private final AdminInterface view;
    private UserDAO userDAO;
    private User user;
    private RandomID randomID;

    public AdminPresenter(AdminView view) {
        this.view = view;
        this.userDAO=new UserDAO();
        this.user=new User();
        randomID=new RandomID();
    }

    public void backButton(){
        view.backButotn();
    }

    public void loadUserList() {
        try {
            List<User> userList = userDAO.findAllUser();
            view.showUserList(userList);
        } catch (Exception e) {
            view.showMessage("Unable to load user list.");
        }
    }

    public void deleteUser(String userID) {
        try {
            userDAO.deleteUser(userID);
            view.showMessage("User deleted successfully.");
        } catch (Exception e) {
            view.showMessage("Unable to delete user.");
        }
    }

    public void addUser(List<String> rows){
        User user=new User(randomID.getRandomID(),rows.get(3),rows.get(4),rows.get(3),rows.get(0),rows.get(1));
        try {
            userDAO.createUser(user);
            view.showMessage("User added successfully.");
        } catch (Exception e) {
            view.showMessage("Unable to add user.");
        }
    }

    public void updateUser(String userId,String rows){
        User user=userDAO.getUser(userId);
        String[] fieldss=rows.split(" ");
        user.setUsername(fieldss[1]);
        user.setFirstName(fieldss[2]);
        user.setLastName(fieldss[3]);
        try {
            userDAO.updateUser(user);
            view.showMessage("User updated successfully.");
        } catch (Exception e) {
            view.showMessage("Unable to update user.");
        }
    }
}
