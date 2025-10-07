package registered;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Emplyoee {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Model> obj = new ArrayList<>();

        System.out.print("How many employees will be registered? ");
        int registered = sc.nextInt();

        for (int i = 0; i < registered; i++) {
            sc.nextLine();
            System.out.println("Emplyoee #" + (i + 1) + ":");
            System.out.print("Id: ");
            int id = sc.nextInt();
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println();
            obj.add(new Model(id ,name,salary));
        }

        System.out.print("Enter the employee id that will have salary increase : ");
        int id = sc.nextInt();
        double percentage = 0;
        boolean verific = false;
        for (int i = 0; i < registered; i++) {
            if (obj.get(i).getId() == id) {
                sc.nextLine();
                System.out.print("Enter the percentage: ");
                percentage = sc.nextDouble();
                percentage = percentage / 100 + 1;
                double salary = obj.get(i).getSalary() * percentage;
                obj.get(i).setSalary(salary);
                verific = true;
            }
        }
        if (!verific) {
            System.out.println("This id does not exist!");
        }
        System.out.println();
        System.out.println("List of employees:");
        for (Model objeto: obj) {
            System.out.println(objeto);
        }


    }
}
