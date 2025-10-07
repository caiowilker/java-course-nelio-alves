package rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Rectangle rectangle = new Rectangle();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter rectangle width and height: ");
        System.out.println("Enter width: ");
        rectangle.width = scanner.nextDouble();
        System.out.println("Enter heidth: ");
        rectangle.height = scanner.nextDouble();

        System.out.println("AREA = " + rectangle.area());
        System.out.println("PERIMETER = " + rectangle.perimetar());
        System.out.println("DIAGOL = " + rectangle.diagonal());


        scanner.close();
    }
}
