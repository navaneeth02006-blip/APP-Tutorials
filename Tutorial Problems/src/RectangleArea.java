import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the length: ");
        double length = input.nextDouble();

        System.out.print("Enter the breadth: ");
        double breadth = input.nextDouble();
        double area = length * breadth;

        System.out.println("Area of the rectangular playground = " + area);

        input.close();
    }
}
