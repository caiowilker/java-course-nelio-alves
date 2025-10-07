package interfaces.ext_fixacao.application;

import interfaces.ext_fixacao.model.entities.Contract;
import interfaces.ext_fixacao.model.entities.Installment;
import interfaces.ext_fixacao.model.service.ContractService;
import interfaces.ext_fixacao.model.service.OnlyPaymentService;
import interfaces.ext_fixacao.model.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        OnlyPaymentService paypalService = new PaypalService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Entre com os dados do contrado:");
        System.out.print("Número: ");
        int number = sc.nextInt();
        System.out.print("Data (dd/MM/yyyyy): ");
        String input = sc.next();
        LocalDate date = LocalDate.parse(input, formatter);
        System.out.print("Valor de contrato: ");
        double amount = sc.nextDouble();
        System.out.print("Entre com o número de parcelas: ");
        int months = sc.nextInt();
        Contract obj = new Contract(number, date, amount, new Installment(date , amount));
        ContractService contractService = new ContractService(paypalService);
        System.out.println();
        System.out.println("Parcelas:");
        contractService.processContract(obj, months);
    }
}
