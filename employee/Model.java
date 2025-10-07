package employee;

import java.util.Locale;
import java.util.Scanner;

public class Model {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.print("Name: " );
        employee.name = sc.nextLine();
        System.out.print("Gross salary: ");
        employee.grossSaralary = sc.nextDouble();
        System.out.print("Tax: ");
        employee.tax = sc.nextDouble();
        System.out.println();
        System.out.print("Employee: " + employee.name + ", $ " + employee.netSalary());
        System.out.println();
        System.out.print("Which percentage to increase salat? ");
        double percentage = sc.nextDouble();
        System.out.println();
        System.out.print("Updatec data: " + employee.name + ", $ " + employee.increaseSalary(percentage));
    }
}
