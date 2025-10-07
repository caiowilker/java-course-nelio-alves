package files;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        List<Product> products = new ArrayList<>();
        String path = "C:\\Users\\Família\\Documents\\Java Spring Boot\\curso-java\\src\\main\\java\\org\\example\\files\\arquivos.csv";


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))){
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] vect = line.split(",");
                String name = vect[0];
                int quantidade = Integer.parseInt(vect[1]);
                double value = Double.parseDouble(vect[2]);
                products.add(new Product(name, quantidade, value));
            }


            boolean sucess = new File(path + "\\out").mkdir();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter bf = new BufferedWriter(new FileWriter(path + "\\out\\summary.csv"))) {
            for (Product line : products) {
                String completo = line.getName() + ", " + String.format("%.2f", line.getTotal());
                bf.write(completo);
                bf.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
