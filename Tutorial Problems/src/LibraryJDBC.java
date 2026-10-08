import java.sql.*;
import java.util.Scanner;

public class LibraryJDBC {
    static final String URL = "jdbc:mysql://localhost:3306/library";
    static final String USER = "root";
    static final String PASSWORD = "root";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
            int choice;
            do {
                System.out.println("\n===== LIBRARY MANAGEMENT =====");
                System.out.println("1. Insert Book");
                System.out.println("2. Search Book");
                System.out.println("3. Display Available Books");
                System.out.println("4. Issue Book");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                choice = sc.nextInt();
                switch (choice) {

                    case 1:
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter Author: ");
                        String author = sc.nextLine();

                        System.out.print("Enter Price: ");
                        double price = sc.nextDouble();

                        String insertSQL =
                                "INSERT INTO Book " +
                                        "(BookID, Title, Author, Price, Availability) " +
                                        "VALUES (?, ?, ?, ?, ?)";

                        PreparedStatement insert = con.prepareStatement(insertSQL);
                        insert.setInt(1, id);
                        insert.setString(2, title);
                        insert.setString(3, author);
                        insert.setDouble(4, price);
                        insert.setBoolean(5, true);

                        insert.executeUpdate();
                        System.out.println(
                                "Book inserted successfully!");
                        break;
                    case 2:
                        System.out.print("Enter Book ID: ");
                        int searchID = sc.nextInt();

                        String searchSQL = "SELECT * FROM Book WHERE BookID = ?";
                        PreparedStatement search = con.prepareStatement(searchSQL);
                        search.setInt(1, searchID);
                        ResultSet rs = search.executeQuery();
                        if (rs.next()) {
                            System.out.println("Book ID: " + rs.getInt("BookID"));
                            System.out.println("Title: " + rs.getString("Title"));
                            System.out.println("Author: " + rs.getString("Author"));
                            System.out.println("Price: Rs. " + rs.getDouble("Price"));
                            System.out.println("Availability: " + rs.getBoolean("Availability"));
                        } else {
                            System.out.println("Book not found!");
                        }
                        break;
                    case 3:

                        String availableSQL = "SELECT * FROM Book " + "WHERE Availability = true";
                        Statement stmt = con.createStatement();
                        ResultSet result = stmt.executeQuery(availableSQL);
                        System.out.println("\n===== AVAILABLE BOOKS =====");
                        while (result.next()) {
                            System.out.println(
                                    "ID: " +
                                            result.getInt("BookID")
                                            + " | Title: "
                                            + result.getString("Title")
                                            + " | Author: "
                                            + result.getString("Author")
                                            + " | Price: Rs."
                                            + result.getDouble("Price"));
                        }
                        break;
                    case 4:
                        System.out.print("Enter Book ID to issue: ");
                        int issueID = sc.nextInt();
                        String updateSQL = "UPDATE Book " + "SET Availability = false " + "WHERE BookID = ?";

                        PreparedStatement update = con.prepareStatement(updateSQL);

                        update.setInt(1, issueID);
                        int rows = update.executeUpdate();

                        if (rows > 0) System.out.println("Book issued successfully!");
                        else
                            System.out.println("Book not found!");
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