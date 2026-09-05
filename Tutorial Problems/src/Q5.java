class Area {

    void calculateArea(int side) {

        int area = side * side;
        System.out.println("Area of Square: " + area);
    }
    void calculateArea(int length, int breadth) {
        int area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }
    void calculateArea(double radius) {
        double area = Math.PI * radius * radius;
        System.out.println("Area of Circle: " + area);
    }
}

public class Q5{
    public static void main(String[] args) {

        Area a = new Area();

        a.calculateArea(5);
        a.calculateArea(10, 6);
        a.calculateArea(7.0);
    }
}