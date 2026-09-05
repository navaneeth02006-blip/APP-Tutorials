import java.util.Scanner;
class Employee {
    int employeeId;
    String name;

    double monthlySalary;
    Employee(int employeeId, String name, double monthlySalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.monthlySalary = monthlySalary;
    }
    void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Monthly Salary: ₹" + monthlySalary);
    }
    double calculateAnnualSalary() {
        return monthlySalary * 12;
    }
    double calculateBonus() {
        if (monthlySalary >= 30000) {
            return calculateAnnualSalary() * 0.10;
        } else {
            return 0;
        }
    }
    void checkEligibility() {
        if (monthlySalary >= 30000) {
            System.out.println("Bonus Eligibility: Eligible");
        } else {
            System.out.println("Bonus Eligibility: Not Eligible");
        }
    }
    void displayEmployee() {

        displayDetails();
        double annualSalary = calculateAnnualSalary();
        double bonus = calculateBonus();
        System.out.println("Annual Salary: ₹" + annualSalary);
        System.out.println("Bonus: ₹" + bonus);
        checkEligibility();
        System.out.println("-----------------------------");
    }
}
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter details of Employee " + (i + 1));
            System.out.print("Employee ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Monthly Salary: ");
            double salary = sc.nextDouble();
            employees[i] = new Employee(id, name, salary);
            System.out.println();
        }
        System.out.println("===== EMPLOYEE DETAILS =====");
        for (int i = 0; i < 5; i++) {
            employees[i].displayEmployee();
        }

        sc.close();
    }
}