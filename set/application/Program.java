package set.application;

import set.model.entities.CursosOnline;

import java.util.*;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
    
        char[] vect = {'A', 'B', 'C'};
        List<CursosOnline> cursosOnlines = new ArrayList<>();
        Set<Integer> ids = new HashSet<>();

        for (int i = 0; i < vect.length; i++) {
            System.out.print("How many students for course " + vect[i] + "? ");
            int value = sc.nextInt();
            sc.nextLine();
            List<Integer> id = new ArrayList<>();
            for (int j = 0; j < value; j++) {
                id.add(sc.nextInt());
                sc.nextLine();
            }
            cursosOnlines.add(new CursosOnline(vect[i], id));
        }
        
        for (CursosOnline obj : cursosOnlines) {
            for (int i = 0; i < obj.getId().size(); i++) {
                ids.add(obj.getId().get(i));
            }
        }
        System.out.println("Total students: " + ids.size());
    }
}
