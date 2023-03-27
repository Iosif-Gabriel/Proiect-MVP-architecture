package View;

import Model.Tables.User;

import javax.swing.*;
import java.util.List;

public interface AdminInterface {
    void showUserList(List<User> userList);
    void showMessage(String message);
    String getSelectedRows(JTable table);
    String[] getAttr(JTable table);
    void backButotn();
}
