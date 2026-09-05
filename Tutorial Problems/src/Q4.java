abstract class Product {
    int productId;
    String name;
    double price;
    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    abstract double calculateDiscount();
    void display() {
        double discount = calculateDiscount();
        double finalPrice = price - discount;
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: Rs." + price);
        System.out.println("Discount: Rs." + discount);
        System.out.println("Final Price: Rs." + finalPrice);
        System.out.println();
    }
}

class Electronics extends Product {
    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    double calculateDiscount() {

        return price * 0.10; // 10% discount
    }
}
class Clothing extends Product {
    Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    double calculateDiscount() {
        return price * 0.20; // 20% discount
    }
}
class Books extends Product {
    Books(int productId, String name, double price) {
        super(productId, name, price);
    }
    double calculateDiscount() {
        return price * 0.15; // 15% discount
    }
}
public class Q4 {
    public static void main(String[] args) {
        Product p1 = new Electronics(101, "Laptop", 50000);
        Product p2 = new Clothing(102, "Shirt", 2000);
        Product p3 = new Books(103, "Java Book", 1000);
        p1.display();
        p2.display();
        p3.display();
    }
}