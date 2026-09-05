class Book {
    String title;
    String author;
    double price;
    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
    }
}
public class Q2 {
    public static void main(String[] args) {
        Book b1 = new Book();

        b1.title = "The Alchemist";
        b1.author = "Paulo Coelho";
        b1.price = 399.50;
        b1.displayDetails();
    }
}