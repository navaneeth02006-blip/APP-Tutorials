import java.sql.*;
import java.util.Scanner;
public class ProductJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/store";
    static final String USER = "root";
    static final String PASSWORD = "root";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected!");
            int choice;
            do {
                System.out.println("\n===== PRODUCT MANAGEMENT =====");
                System.out.println("1. Insert Product");
                System.out.println("2. Search Product");
                System.out.println("3. Update Quantity");
                System.out.println("4. Display Low Stock Products");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:

                        System.out.print("Enter Product ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Product Name: ");
                        String name = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        System.out.print("Enter Quantity: ");
                        int quantity = sc.nextInt();

                        String insertSQL = "INSERT INTO Product " + "(ProductID, ProductName, Price, Quantity) " + "VALUES (?, ?, ?, ?)";

                        PreparedStatement insert = con.prepareStatement(insertSQL);
                        insert.setInt(1, id);
                        insert.setString(2, name);
                        insert.setDouble(3, price);
                        insert.setInt(4, quantity);

                        insert.executeUpdate();
                        System.out.println("Product inserted successfully!");
                        break;
                    case 2:
                        System.out.print("Enter Product ID: ");
                        int searchID = sc.nextInt();
                        String searchSQL = "SELECT * FROM Product " + "WHERE ProductID = ?";
                        PreparedStatement search = con.prepareStatement(searchSQL);
                        search.setInt(1, searchID);
                        ResultSet rs = search.executeQuery();
                        if (rs.next()) {
                            System.out.println("Product ID: " + rs.getInt("ProductID"));
                            System.out.println("Product Name: " + rs.getString("ProductName"));
                            System.out.println("Price: Rs. " + rs.getDouble("Price"));
                            System.out.println("Quantity: " + rs.getInt("Quantity"));
                        } else {
                            System.out.println("Product not found!");
                        }
                        break;
                    case 3:
                        System.out.print("Enter Product ID: ");
                        int updateID = sc.nextInt();
                        System.out.print("Enter New Quantity: ");
                        int newQuantity = sc.nextInt();
                        String updateSQL = "UPDATE Product " + "SET Quantity = ? " + "WHERE ProductID = ?";

                        PreparedStatement update = con.prepareStatement(updateSQL);
                        update.setInt(1, newQuantity);
                        update.setInt(2, updateID);
                        int rows = update.executeUpdate();
                        if (rows > 0)
                            System.out.println("Quantity updated successfully!");
                        else
                            System.out.println("Product not found!");
                        break;
                    case 4:
                        String lowStockSQL = "SELECT * FROM Product " + "WHERE Quantity < 10";
                        PreparedStatement lowStock = con.prepareStatement(lowStockSQL);
                        ResultSet result = lowStock.executeQuery();
                        System.out.println("\n===== LOW STOCK PRODUCTS =====");
                        while (result.next()) {
                            System.out.println("ID: "
                                            + result.getInt("ProductID")
                                            + " | Name: "
                                            + result.getString("ProductName")
                                            + " | Price: Rs."
                                            + result.getDouble("Price")
                                            + " | Quantity: "
                                            + result.getInt("Quantity"));
                        }
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } while (choice != 5);
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        sc.close();
    }
}