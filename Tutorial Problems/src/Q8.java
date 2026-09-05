class Temperature {
    double celsius;
    void convert() {
        double fahrenheit = (9.0 / 5.0) * celsius + 32;
        System.out.println("Celsius: " + celsius);
        System.out.println("Fahrenheit: " + fahrenheit);
    }
}
public class Q8 {
    public static void main(String[] args) {
        Temperature t = new Temperature();

        t.celsius = 25;
        t.convert();
    }
}