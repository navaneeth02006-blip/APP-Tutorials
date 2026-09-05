import java.util.Scanner;

public class HighestScore {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter score of Student 1: ");
        int s1 = input.nextInt();

        System.out.print("Enter score of Student 2: ");
        int s2 = input.nextInt();

        System.out.print("Enter score of Student 3: ");
        int s3 = input.nextInt();

        if (s1 >= s2 && s1 >= s3) {
            System.out.println("Student 1 has the highest score: " + s1);
        } else if (s2 >= s1 && s2 >= s3) {
            System.out.println("Student 2 has the highest score: " + s2);
        } else {
            System.out.println("Student 3 has the highest score: " + s3);

        }

        input.close();
    }
}