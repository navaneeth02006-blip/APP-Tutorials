package student;

public class Student {
    private int studentId;
    private String name;
    private String department;

    public Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }
    public void displaystudent() {
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
    }
}
package course;

public class Course {
    private String courseId;
    private String courseName;
    private int credits;

    public Course(String courseId, String courseName, int credits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
    }

    public void displaycourse() {
        System.out.println("Course ID   : " + courseId);
        System.out.println("Course Name : " + courseName);
        System.out.println("Credits     : " + credits);
    }
}
import student.Student;
import course.Course;

public class Q1 {
    public static void main(String[] args) {

        Student student = new Student(101, "Rahul", "Computer Science");
        Course course = new Course("CS101", "Java Programming", 4);

        System.out.println("----- Student Information -----");
        student.displaystudent();

        System.out.println("\n----- Course Information -----");
        course.displaycourse();
    }
}