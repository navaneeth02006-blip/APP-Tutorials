import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class StudentCourseManagement {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Course Management");
        frame.setSize(650, 450);
        frame.setLayout(new BorderLayout());
        String courses[] = {
                "Java Programming",
                "Python Programming",
                "Data Structures",
                "Database Management",
                "Computer Networks"
        };

        JList<String> courseList = new JList<>(courses);
        JScrollPane listScrollPane = new JScrollPane(courseList);
        JTextField nameField = new JTextField(15);

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Student Name:"));
        topPanel.add(nameField);
        JButton addButton = new JButton("Add Registration");
        JButton removeButton = new JButton("Remove Registration");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        String columns[] = {
                "Student Name",
                "Selected Course",
                "Enrollment Status"
        };
        DefaultTableModel model =
                new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(table);

        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String course = courseList.getSelectedValue();

            if (name.isEmpty() || course == null) {
                JOptionPane.showMessageDialog(
                        frame,
                        "Enter student name and select a course!"
                );
            } else {
                model.addRow(new Object[]{
                        name,
                        course,
                        "Enrolled"
                });
                nameField.setText("");
                courseList.clearSelection();
            }
        });
        removeButton.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                model.removeRow(row);
            } else {
                JOptionPane.showMessageDialog(
                        frame,
                        "Select a registration to remove!"
                );
            }
        });
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(listScrollPane, BorderLayout.WEST);
        frame.add(tableScrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}