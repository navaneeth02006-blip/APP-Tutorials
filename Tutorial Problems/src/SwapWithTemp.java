import java.util.Scanner;

public class SwapWithTemp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first roll number: ");
        int roll1 = input.nextInt();

        System.out.print("Enter second roll number: ");
        int roll2 = input.nextInt();
        int temp = roll1;
        roll1 = roll2;
        roll2 = temp;

        System.out.println("After Swapping:");
        System.out.println("First Roll Number = " + roll1);
        System.out.println("Second Roll Number = " + roll2);

        input.close();

    }
}