import java.util.Scanner;

class Students {
    String name;
    int rollNo;
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
}
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Students s = new Students();
        System.out.print("Enter student name: ");
        s.name = sc.nextLine();
        System.out.print("Enter roll number: ");
        s.rollNo = sc.nextInt();
        System.out.println("\nStudent Details:");
        s.display();

        sc.close();
    }
}