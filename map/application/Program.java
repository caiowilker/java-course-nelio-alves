package map.application;

import map.model.entities.Candidato;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file full path: ");
        String path = sc.nextLine();
        Map<Candidato, Integer> list = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] vect = line.split(",");
                Candidato candidato = new Candidato(vect[0].trim());
                if (list.containsKey(candidato)) {
                    int value = list.get(candidato) + Integer.parseInt(vect[1].trim());
                    list.put(candidato, value);
                }
                else {
                    list.put(new Candidato(vect[0]), Integer.parseInt(vect[1].trim()));
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Candidato obj : list.keySet()) {
            System.out.println(obj.getName() + ": " + list.get(obj));
        }
    }

}
