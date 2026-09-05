import java.util.Scanner;

public class PassFail {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter student's marks: ");
        int marks = input.nextInt();
        if (marks >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        input.close();
    }
}