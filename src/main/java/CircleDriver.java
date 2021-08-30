import java.util.Scanner;

public class CircleDriver {

    public static void main(String[] args) {

        Circle circle = new Circle(takeRadius());
        System.out.println(circle.getArea());
    }

    public static double takeRadius() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter radius: ");
        while(!scanner.hasNextDouble()) {
            System.out.println("Invalid input");
            scanner.nextLine();
            System.out.println("Enter radius: ");
        }

        return Double.parseDouble(scanner.nextLine());
    }
}
