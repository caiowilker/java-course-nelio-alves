package cotacao;

import java.util.Locale;
import java.util.Scanner;

public class PriceDollar {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("What is the dollar price? ");
        CurrencyConverter.price = sc.nextFloat();
        System.out.print("How many dollars will be bought? ");
        CurrencyConverter.quantidade = sc.nextFloat();
        System.out.printf("Amount to be paid in reais = %.2f%n", CurrencyConverter.convert());
    }
}
