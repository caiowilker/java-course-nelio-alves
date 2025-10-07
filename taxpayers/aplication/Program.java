package taxpayers.aplication;

import taxpayers.entities.PessoaFisica;
import taxpayers.entities.PessoaJuridica;
import taxpayers.entities.TaxPayers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<TaxPayers> taxPayers = new ArrayList<>();
        System.out.print("Enter the number of tax payers: ");
        int number = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= number ; i++) {
            System.out.println("Tax payer #" + i + " data:");
            System.out.print("Individual or company (i/c)? ");
            char sh = sc.next().charAt(0);
            sc.nextLine();
            if (sh == 'i') {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Anual income: ");
                double salary = sc.nextDouble();
                System.out.print("Heaulth expenditures: ");
                double expend = sc.nextDouble();
                taxPayers.add(new PessoaFisica(name, salary, expend));
            }else {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Anual income: ");
                double salary = sc.nextDouble();
                System.out.print("Number of employers: ");
                int employers = sc.nextInt();
                taxPayers.add(new PessoaJuridica(name, salary, employers));
            }

        }
        System.out.println();
        System.out.println("TAXES PAID:");
        for (TaxPayers obj : taxPayers) {
            System.out.println(obj.getName()
                    + ": $ "
                    + String.format("%.2f", obj.impostoPago()));
        }

        double total = 0;
        for (TaxPayers tot : taxPayers) {
            total += tot.impostoPago();
        }
        System.out.println();
        System.out.println("TOTAL TAXES: $ "+ String.format("%.2f",total));
    }
}
