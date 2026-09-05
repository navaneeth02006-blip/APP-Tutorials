import java.util.Scanner;

public class SupermarketCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter price of first product: ");
        int price1 = input.nextInt();
        System.out.print("Enter price of second product: ");
        int price2 = input.nextInt();
        int total = price1 + price2;
        int difference = price1 - price2;
        int product = price1 * price2;
        int quotient = price1 / price2;
        int remainder = price1 % price2;
        System.out.println("\nResults:");
        System.out.println("Total = " + total);
        System.out.println("Difference = " + difference);
        System.out.println("Product = " + product);
        System.out.println("Quotient = " + quotient);

        System.out.println("Remainder = " + remainder);

        input.close();
    }
}