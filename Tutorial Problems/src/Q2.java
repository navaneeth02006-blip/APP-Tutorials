class Employee {
    String name;
    int employeeId;
    double basicSalary;
    Employee(String name, int employeeId, double basicSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.basicSalary = basicSalary;
    }
    double calculateSalary() {
        return basicSalary;
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Salary: " + calculateSalary());
        System.out.println();
    }
}
class Professor extends Employee {
    Professor(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }
    double calculateSalary() {
        return basicSalary + 10000;
    }

}

class LabAssistant extends Employee {
    LabAssistant(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }
    double calculateSalary() {
        return basicSalary + 5000;
    }
}
class AdministrativeStaff extends Employee {
    AdministrativeStaff(String name, int employeeId, double basicSalary) {
        super(name, employeeId, basicSalary);
    }
    double calculateSalary() {
        return basicSalary + 3000;
    }
}
public class Q2 {
    public static void main(String[] args) {
        Professor p = new Professor("John", 101, 50000);
        LabAssistant l = new LabAssistant("David", 102, 30000);
        AdministrativeStaff a = new AdministrativeStaff("Mary", 103, 25000);
        System.out.println("Professor Details:");
        p.display();
        System.out.println("Lab Assistant Details:");
        l.display();
        System.out.println("Administrative Staff Details:");
        a.display();

    }
}