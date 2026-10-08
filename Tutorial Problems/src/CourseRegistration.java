import java.sql.*;
import java.util.Scanner;
public class CourseRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "root";
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected!");
            System.out.print("Enter Course Code: ");
            String code = sc.nextLine();

            String sql = "SELECT * FROM CourseRegistration " + "WHERE CourseCode = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, code);

            ResultSet rs = ps.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.println("\nStudent ID: " + rs.getInt("StudentID"));
                System.out.println("Student Name: " + rs.getString("StudentName"));
                System.out.println("Course Code: " + rs.getString("CourseCode"));
                System.out.println("Course Name: " + rs.getString("CourseName"));
                System.out.println("Semester: " + rs.getInt("Semester"));
            }
            if (!found) {
                System.out.println("No students registered for course " + code);
            }
            con.close();
            sc.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
