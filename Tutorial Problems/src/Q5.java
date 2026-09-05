class Studentss {
    String name;
    int age;
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
public class Q5 {
    public static void main(String[] args) {
        Studentss s1 = new Studentss();
        Studentss s2 = new Studentss();
        s1.name = "Arun";
        s1.age = 18;
        s2.name = "Rahul";
        s2.age = 19;
        System.out.println("Student 1 Details:");

        s1.display();
        System.out.println("\nStudent 2 Details:");
        s2.display();
    }
}