package View;

public interface LogInInterface {
    String getUsername();
    String getPassword();
    void showErrorMessage(String message);
    void showStudentGUI();
    void showAdminGUI();
}
