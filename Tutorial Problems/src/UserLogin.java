import javax.swing.*;

public class UserLogin {
    public static void main(String[] args) {

        JFrame frame = new JFrame("User Login");
        frame.setSize(400, 300);
        frame.setLayout(null);
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(40, 40, 100, 30);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 40, 180, 30);
        frame.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(40, 80, 100, 30);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 80, 180, 30);
        frame.add(passField);

        JCheckBox remember = new JCheckBox("Remember Me");
        remember.setBounds(150, 120, 120, 30);
        frame.add(remember);

        JCheckBox notification = new JCheckBox("Receive Notifications");
        notification.setBounds(150, 150, 180, 30);
        frame.add(notification);

        JButton login = new JButton("Login");
        login.setBounds(150, 200, 100, 35);
        frame.add(login);

        login.addActionListener(e -> {

            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Login Successful!\n"
                                + "Welcome, " + username
                                + "\nRemember Me: "
                                + remember.isSelected()
                                + "\nNotifications: "
                                + notification.isSelected()
                );
            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Invalid Username or Password!",
                        "Login Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}