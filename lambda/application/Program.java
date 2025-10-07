package lambda.application;

import lambda.entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new ArrayList<>();

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();
        System.out.print("Enter salary: ");
        Double salary = sc.nextDouble();
        System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary));

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String file;
            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());


            while ((file = br.readLine()) != null) {
                String[] vect = file.split(",");
                list.add(new Employee(vect[0], vect[1], Double.parseDouble(vect[2])));

                List<String> newList = list.stream()
                        .filter(p -> p.getSalary() > salary)
                        .map(p -> p.getEmail())
                        .sorted(comp)
                        .collect(Collectors.toList());

                newList.forEach(System.out::println);

                Double sum = list.stream()
                                .filter(p -> p.getName().charAt(0) == 'M')
                                        .map(p -> p.getSalary())
                                                .reduce(0.0, (x, y) -> x + y);

                System.out.println("Sum of salary of people whose name atarts with 'M': " + String.format("%.2f", sum));


            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
