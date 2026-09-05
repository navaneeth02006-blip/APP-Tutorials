import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] prices = new int[5];
        int total = 0;

        for (int i = 0; i < 5; i++) {
            prices[i] = sc.nextInt();
            total = total + prices[i];
        }
        System.out.println("Total Bill : " + total);

        if (total > 5000) {
            System.out.println("Discount Applicable");
        } else {
            System.out.println("No Discount");
        }
        sc.close();
    }
}
