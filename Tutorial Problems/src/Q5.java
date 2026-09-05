class Student {
    String name;
    int rollNo;
    String department;

    Student(String name, int rollNo, String department) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
    }

    void displayStudent() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Department: " + department);
    }
}

class Course {
    String courseName;
    String courseCode;
    int credits;

    Course(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
    }

    void displayCourse() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Course Code: " + courseCode);
        System.out.println("Credits: " + credits);
    }
}

public class Q5 {
    public static void main(String[] args) {

        Student s = new Student("Rahul", 101, "Computer Science");
        Course c = new Course("Java Programming", "CS101", 4);

        System.out.println("Student Details:");
        s.displayStudent();

        System.out.println();

        System.out.println("Course Details:");
        c.displayCourse();
    }
}