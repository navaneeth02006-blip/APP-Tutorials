import java.util.Scanner;

public class EvenOddSeat {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the seat number: ");
        int seatNumber = input.nextInt();
        if (seatNumber % 2 == 0) {
            System.out.println("The seat number is Even.");
        } else {
            System.out.println("The seat number is Odd.");
        }

        input.close();
    }
}