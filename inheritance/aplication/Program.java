package inheritance.aplication;

import inheritance.entities.ImportedProduct;
import inheritance.entities.Product;
import inheritance.entities.UsedProduct;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> productList = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int value = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= value; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char sh = sc.next().charAt(0);
            sc.nextLine();
            if (sh == 'c') {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                Double price = sc.nextDouble();
                productList.add(new Product(name, price));
            } else if (sh == 'u') {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                Double price = sc.nextDouble();
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date date = new Date(sc.next());
                productList.add(new UsedProduct(name, price, date));
            }else {
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Price: ");
                Double price = sc.nextDouble();
                System.out.print("Customs fee: ");
                Double customs = sc.nextDouble();
                productList.add(new ImportedProduct(name, price, customs));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product obj: productList) {
            System.out.println(obj.getName() + " " + obj.priceTag());
        }
    }
}
