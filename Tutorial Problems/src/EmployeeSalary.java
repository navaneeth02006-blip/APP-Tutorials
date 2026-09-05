import java.util.Scanner;

public class EmployeeSalary {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Basic Salary: ");
        double basicSalary = input.nextDouble();

        System.out.print("Enter Allowance: ");
        double allowance = input.nextDouble();

        double totalSalary = basicSalary + allowance;
        System.out.println("Total Monthly Salary = " + totalSalary);

        input.close();
    }
}