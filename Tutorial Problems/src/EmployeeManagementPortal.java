import javax.swing.*;

class EmployeeModel {
    String username = "admin";
    String password = "admin123";
    String employeeID;
    String employeeName;
    String department;
    boolean validateLogin(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }
    boolean changePassword(String oldPass, String newPass,
                           String confirmPass) {
        if (!password.equals(oldPass))
            return false;
        if (!newPass.equals(confirmPass))
            return false;
        password = newPass;
        return true;
    }
    void addEmployee(String id, String name, String dept) {
        employeeID = id;
        employeeName = name;
        department = dept;
    }
}
public class EmployeeManagementPortal extends JFrame {
    EmployeeModel model = new EmployeeModel();

    JTextField usernameField;
    JPasswordField passwordField;
    JButton loginButton;
    JFrame mainFrame;

    EmployeeManagementPortal() {

        setTitle("Employee Management Portal - Login");
        setSize(400, 250);
        setLayout(null);
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 40, 100, 30);
        add(userLabel);

        usernameField = new JTextField();
        usernameField.setBounds(150, 40, 180, 30);
        add(usernameField);
        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 80, 100, 30);
        add(passLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 80, 180, 30);
        add(passwordField);
        loginButton = new JButton("Login");
        loginButton.setBounds(150, 130, 100, 35);
        add(loginButton);

        loginButton.addActionListener(e -> {

            String user = usernameField.getText();
            String pass = new String(passwordField.getPassword());

            if (model.validateLogin(user, pass)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Login Successful!"
                );
                dispose();
                showMainWindow();
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Invalid Username or Password!",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    void showMainWindow() {

        mainFrame = new JFrame("Employee Management Portal");
        mainFrame.setSize(600, 400);
        mainFrame.setLayout(null);

        JMenuBar menuBar = new JMenuBar();
        JMenu employeeMenu = new JMenu("Employee");
        JMenuItem addEmployee = new JMenuItem("Add Employee");
        JMenuItem viewEmployee = new JMenuItem("View Employee");
        employeeMenu.add(addEmployee);
        employeeMenu.add(viewEmployee);
        JMenu toolsMenu = new JMenu("Tools");
        JMenuItem changePassword = new JMenuItem("Change Password");
        toolsMenu.add(changePassword);
        JMenu exitMenu = new JMenu("Exit");

        JMenuItem logout = new JMenuItem("Logout");
        JMenuItem exitApplication = new JMenuItem("Exit Application");
        exitMenu.add(logout);
        exitMenu.add(exitApplication);
        menuBar.add(employeeMenu);
        menuBar.add(toolsMenu);
        menuBar.add(exitMenu);

        mainFrame.setJMenuBar(menuBar);

        addEmployee.addActionListener(e -> {
            JTextField idField = new JTextField();
            JTextField nameField = new JTextField();
            JTextField deptField = new JTextField();
            Object[] fields = {
                    "Employee ID:", idField,
                    "Employee Name:", nameField,
                    "Department:", deptField
            };
            int result = JOptionPane.showConfirmDialog(
                    mainFrame,
                    fields,
                    "Add Employee",
                    JOptionPane.OK_CANCEL_OPTION
            );
            if (result == JOptionPane.OK_OPTION) {
                model.addEmployee(
                        idField.getText(),
                        nameField.getText(),
                        deptField.getText()
                );
                JOptionPane.showMessageDialog(
                        mainFrame,
                        "Employee Added Successfully!"
                );
            }
        });
        viewEmployee.addActionListener(e -> {

            if (model.employeeID == null) {

                JOptionPane.showMessageDialog(
                        mainFrame,
                        "No Employee Added!"
                );
            } else {
                JOptionPane.showMessageDialog(
                        mainFrame,
                        "Employee ID: "
                                + model.employeeID
                                + "\nEmployee Name: "
                                + model.employeeName
                                + "\nDepartment: "
                                + model.department
                );
            }
        });
        changePassword.addActionListener(e -> {
            JPasswordField oldPass = new JPasswordField();
            JPasswordField newPass = new JPasswordField();
            JPasswordField confirmPass = new JPasswordField();
            Object[] fields = {
                    "Old Password:", oldPass,
                    "New Password:", newPass,
                    "Confirm Password:", confirmPass
            };
            int result = JOptionPane.showConfirmDialog(
                    mainFrame,
                    fields,
                    "Change Password",
                    JOptionPane.OK_CANCEL_OPTION
            );
            if (result == JOptionPane.OK_OPTION) {
                String oldPassword = new String(oldPass.getPassword());
                String newPassword = new String(newPass.getPassword());
                String confirmPassword = new String(confirmPass.getPassword());
                if (!model.password.equals(oldPassword)) {

                    JOptionPane.showMessageDialog(
                            mainFrame,
                            "Old Password is incorrect!"
                    );
                } else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(
                            mainFrame,
                            "New Password and Confirm Password do not match!"
                    );
                } else {
                    model.changePassword(
                            oldPassword,
                            newPassword,
                            confirmPassword
                    );
                    JOptionPane.showMessageDialog(
                            mainFrame,
                            "Password Changed Successfully!"
                    );
                }
            }
        });
        logout.addActionListener(e -> {
            mainFrame.dispose();
            new EmployeeManagementPortal();
        });
        exitApplication.addActionListener(e -> {
            System.exit(0);
        });
        mainFrame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );
        mainFrame.setVisible(true);
    }
    public static void main(String[] args) {
        new EmployeeManagementPortal();
    }
}