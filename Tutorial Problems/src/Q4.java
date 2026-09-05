import java.util.Scanner;

class Rectangle {
    double length;
    double breadth;
    void calculateArea() {
        double area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
}
public class Q4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Rectangle r = new Rectangle();
        System.out.print("Enter length: ");
        r.length = sc.nextDouble();
        System.out.print("Enter breadth: ");
        r.breadth = sc.nextDouble();

        r.calculateArea();
        sc.close();
    }
}