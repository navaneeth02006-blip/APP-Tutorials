import javax.swing.*;

class StudentModel {
    String name;
    double total, average;
    String grade;
    void calculate(String name, double m1, double m2, double m3) {

        this.name = name;
        total = m1 + m2 + m3;
        average = total / 3;
        if (average >= 90)
            grade = "A";
        else if (average >= 75)
            grade = "B";
        else if (average >= 60)
            grade = "C";
        else if (average >= 50)
            grade = "D";
        else
            grade = "F";
    }
}
public class StudentGradeCalculator extends JFrame {

    JTextField nameField, mark1Field, mark2Field, mark3Field;
    JButton calculateButton;
    JLabel totalLabel, averageLabel, gradeLabel;

    StudentModel model = new StudentModel();

    StudentGradeCalculator() {

        setTitle("Student Grade Calculator");
        setSize(400, 400);
        setLayout(null);

        JLabel name = new JLabel("Student Name:");
        name.setBounds(30, 30, 120, 30);
        add(name);

        nameField = new JTextField();
        nameField.setBounds(160, 30, 180, 30);
        add(nameField);

        JLabel sub1 = new JLabel("Subject 1:");
        sub1.setBounds(30, 70, 120, 30);
        add(sub1);

        mark1Field = new JTextField();
        mark1Field.setBounds(160, 70, 180, 30);
        add(mark1Field);

        JLabel sub2 = new JLabel("Subject 2:");
        sub2.setBounds(30, 110, 120, 30);
        add(sub2);

        mark2Field = new JTextField();
        mark2Field.setBounds(160, 110, 180, 30);
        add(mark2Field);

        JLabel sub3 = new JLabel("Subject 3:");
        sub3.setBounds(30, 150, 120, 30);
        add(sub3);

        mark3Field = new JTextField();
        mark3Field.setBounds(160, 150, 180, 30);
        add(mark3Field);

        calculateButton = new JButton("Calculate Result");
        calculateButton.setBounds(110, 200, 170, 35);
        add(calculateButton);

        totalLabel = new JLabel("Total: ");
        totalLabel.setBounds(30, 250, 250, 30);
        add(totalLabel);

        averageLabel = new JLabel("Average: ");
        averageLabel.setBounds(30, 280, 250, 30);
        add(averageLabel);

        gradeLabel = new JLabel("Grade: ");
        gradeLabel.setBounds(30, 310, 250, 30);
        add(gradeLabel);

        calculateButton.addActionListener(e -> {

            try {
                String nameValue = nameField.getText();

                double m1 = Double.parseDouble(
                        mark1Field.getText());

                double m2 = Double.parseDouble(
                        mark2Field.getText());

                double m3 = Double.parseDouble(
                        mark3Field.getText());

                model.calculate(nameValue, m1, m2, m3);

                totalLabel.setText("Total: " + model.total);
                averageLabel.setText("Average: " + model.average);
                gradeLabel.setText("Grade: " + model.grade);
                JOptionPane.showMessageDialog(this, "Result Calculated Successfully!");
            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        this,
                        "Please enter valid marks!");
            }
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {

        new StudentGradeCalculator();
    }
}
