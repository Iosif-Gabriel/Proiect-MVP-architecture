package View;

import Model.Tables.User;
import Presenter.AdminPresenter;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdminView extends JFrame implements ActionListener,AdminInterface {

    private JPanel panel1;
    private JButton backButton;
    private JTable userTable;
    private JButton searchButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton createButton;
    private AdminPresenter adminPresenter;

    public AdminView() {
        setContentPane(panel1);
        setSize(new Dimension(500, 480));
        setVisible(true);
        backButton.addActionListener(this);
        searchButton.addActionListener(this);
        deleteButton.addActionListener(this);
        updateButton.addActionListener(this);
        createButton.addActionListener(this);
        adminPresenter=new AdminPresenter(this);

    }

    private void getUserFields() {
        // Create the dialog
        JDialog dialog = new JDialog();
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setLayout(new GridLayout(7, 2));

        // Add the text fields
        dialog.add(new JLabel("UserName:"));
        JTextField field1 = new JTextField();
        dialog.add(field1);

        dialog.add(new JLabel("Password:"));
        JTextField field2 = new JTextField();
        dialog.add(field2);

        dialog.add(new JLabel("Last Name:"));
        JTextField field3 = new JTextField();
        dialog.add(field3);

        dialog.add(new JLabel("First Name:"));
        JTextField field4 = new JTextField();
        dialog.add(field4);

        dialog.add(new JLabel("UserType:"));
        JTextField field5 = new JTextField();
        dialog.add(field5);

        // Add the button
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle the save button action
                String value1 = field1.getText();
                String value2 = field2.getText();
                String value3 = field3.getText();
                String value4 = field4.getText();
                String value5 = field5.getText();

                List<String> userFields = Arrays.asList(value1, value2, value3, value4, value5);
                adminPresenter.addUser(userFields);

                // Close the dialog
                dialog.dispose();
            }
        });
        dialog.add(saveButton);

        // Show the dialog
        dialog.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==backButton){
            adminPresenter.backButton();
        }
        if(e.getSource()==searchButton){
            adminPresenter.loadUserList();
        }
        if(e.getSource()==deleteButton){
            adminPresenter.deleteUser(getAttr(userTable)[0]);
        }
        if(e.getSource()==createButton){
           getUserFields();
        }
        if(e.getSource()==updateButton){
            adminPresenter.updateUser(getAttr(userTable)[0],getSelectedRows(userTable));
        }

    }


    @Override
    public void showUserList(List<User> userList) {
        // Create a new table model with columns for user ID, username, and user type
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("User Name");
        model.addColumn("First Name");
        model.addColumn("Last Name");
        model.addColumn("User Type");

        // Add a row for each user in the list
        for (User user : userList) {
            Object[] row = {user.getIdUser(), user.getUsername(),user.getFirstName(),user.getLastName(), user.getUserType()};
            model.addRow(row);
        }

        // Set the table's model to the new table model
        userTable.setModel(model);
    }

    @Override
    public String getSelectedRows(JTable table) {
        StringBuilder sb = new StringBuilder();
        int[] selectedRows = table.getSelectedRows();
        for (int i : selectedRows) {
            for (int j = 0; j < table.getColumnCount(); j++) {
                Object value = table.getValueAt(i, j);
                sb.append(value);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String[] getAttr(JTable table){
        String split=getSelectedRows(table);
        return split.split(" ");
    }

    @Override
    public void backButotn() {
        this.dispose();
        new FirstView();
    }

    @Override
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this,message);
    }

}
