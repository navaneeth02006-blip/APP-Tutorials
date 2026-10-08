import javax.swing.*;

public class StudentRegistration {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Student Registration");
        frame.setSize(400, 350);
        frame.setLayout(null);

        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setBounds(30, 30, 120, 30);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 30, 180, 30);
        frame.add(nameField);

        JLabel regLabel = new JLabel("Register No:");
        regLabel.setBounds(30, 70, 120, 30);
        frame.add(regLabel);

        JTextField regField = new JTextField();
        regField.setBounds(150, 70, 180, 30);
        frame.add(regField);

        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(30, 110, 120, 30);
        frame.add(genderLabel);

        JRadioButton male = new JRadioButton("Male");
        male.setBounds(150, 110, 70, 30);

        JRadioButton female = new JRadioButton("Female");
        female.setBounds(220, 110, 80, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        frame.add(male);
        frame.add(female);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(30, 150, 120, 30);
        frame.add(deptLabel);

        String departments[] = {"CSE", "ECE", "EEE", "Mechanical", "Civil"};
        JComboBox<String> department = new JComboBox<>(departments);
        department.setBounds(150, 150, 180, 30);
        frame.add(department);
        JButton submit = new JButton("Submit");
        submit.setBounds(140, 210, 100, 35);
        frame.add(submit);

        submit.addActionListener(e -> {
            String name = nameField.getText();
            String regNo = regField.getText();

            String gender;
            if (male.isSelected())
                gender = "Male";
            else if (female.isSelected())
                gender = "Female";
            else
                gender = "Not Selected";
            String dept = department.getSelectedItem().toString();
            JOptionPane.showMessageDialog(
                    frame,
                    "Student Registration Details\n\n"
                            + "Name: " + name + "\n"
                            + "Register No: " + regNo + "\n"
                            + "Gender: " + gender + "\n"
                            + "Department: " + dept
            );
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
