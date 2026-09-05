class Employee {
    String name;
    int id;
    double salary;
    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary);
    }
}
public class Q6 {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        e1.name = "Arun";
        e1.id = 101;

        e1.salary = 25000;
        e2.name = "Rahul";
        e2.id = 102;
        e2.salary = 30000;
        System.out.println("Employee 1 Details:");
        e1.display();
        System.out.println("\nEmployee 2 Details:");
        e2.display();
    }
}
