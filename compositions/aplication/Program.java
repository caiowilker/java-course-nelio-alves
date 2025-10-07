package compositions.aplication;

import compositions.entities.*;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        Order order = new Order();
        Product product = null;

        System.out.println("Enter client data");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date date = new Date(sc.next());
        Client client = new Client(name, email, date);
        System.out.println("Enter order data:");
        System.out.print("Status: ");
        sc.nextLine();
        String status = sc.nextLine();
        order.setStatus(OrderStatus.valueOf(status));
        System.out.print("How many items to this order? ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i<num; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:");
            System.out.print("Product name: ");
            String nome = sc.nextLine();
            System.out.print("Product price: ");
            Double value = sc.nextDouble();
            System.out.print("Quatity: ");
            Integer quatity = sc.nextInt();
            product = new Product(nome, value);
            OrderItem orderItem = new OrderItem(quatity, value, product);
            order.addItem(orderItem);
            sc.nextLine();
        }

        System.out.println(order);
        System.out.println(client);

        for (OrderItem obj : order.getItem()) {
            System.out.println(
                    obj.getName()
                    + ", $"
                    + obj.getPrice()
                    + ", Quantity: "
                    + obj.getQuantity()
                    + ", "
                    + "Subtotal: $"
                    + obj.subTotal());
        }

        System.out.println("Total price: $" + order.total());
    }
}
