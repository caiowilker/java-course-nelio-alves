package alturas;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantas pessoas serão cadastradas: ");
        int n = sc.nextInt();
        Model[] name = new Model[n];
        Model[] idade = new Model[n];
        Model[] altura = new Model[n];

        int porcentagem = 0;
        for (int i = 0; i < n; i++) {
            sc.nextLine();
            System.out.println("Dados da " + (i + 1) + "a pessoa:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Idade: ");
            int age = sc.nextInt();
            System.out.print("Altura: ");
            double height = sc.nextDouble();
            name[i] = new Model(nome);
            idade[i] = new Model(age);
            altura[i] = new Model(height);
        }

        int soma = 0;
        for (int i = 0; i < altura.length; i++) {
            soma += altura[i].getAltura();
        }

        int cont = 0;
        for (int i = 0; i < idade.length; i++) {
            if (idade[i].getIdade() < 16) {
                cont++;
            }
        }
        if (cont != 0) {
            porcentagem = cont * 100 / n;
        }
        System.out.println();
        System.out.printf("Altura média: %.2f%", (soma / altura.length));
        System.out.printf("Pessoas com menos de 16 anos: %.2%%", porcentagem);

        for (int i1 = 0; i1 < idade.length; i1++) {
            if (idade[i1].getIdade() < 16) {
                System.out.println(name[i1].getName());
            }
        }

        sc.close();

    }
}