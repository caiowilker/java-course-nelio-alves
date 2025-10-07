package bank;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class BankAccount {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Model account01 = new Model();
        Util util = new Util(account01);

        System.out.print("Enter account number: ");
        int num = sc.nextInt();
        account01.setNumConta(num);
        sc.nextLine();
        System.out.print("Enter account holder: ");
        String name = sc.nextLine();
        account01.setName(name);
        System.out.print("Is there na initial deposit (y/n)? ");
        String initial = sc.nextLine();
        String text = initial.toLowerCase();
        account01.setInitial(text);
        if (Objects.equals(account01.getInitial(), "y")) {
            System.out.print("Enter initial deposit value: ");
            double deposit = sc.nextDouble();
            util.deposit(deposit);
            System.out.println();
            System.out.println();
        }
        System.out.println("Account data:");
        System.out.print("Account "
                + account01.getNumConta()
                + ", Holder: " + account01.getName()
                + ", Balance: $ "
                + String.format("%.2f",account01.getSaldo()));
        System.out.println();
        System.out.println();
        System.out.print("Entera a deposit value: ");
        double deposit = sc.nextDouble();
        util.deposit(deposit);
        System.out.print(account01.toString());
        System.out.println();
        System.out.println();
        System.out.print("Entera a withdraw value: ");
        double sacar = sc.nextDouble();
        util.sacar(sacar);
        System.out.print(account01.toString());


    }
}
