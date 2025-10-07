package student;

public class Student {
    public String name;
    public double n1;
    public double n2;
    public double n3;
    public double notaFinal;

    public double notaFinal() {
        this.notaFinal = (n1 + n2 + n3);
        return notaFinal;
    }

    public void status() {
        if (notaFinal > 60) {
            System.out.println();
            System.out.println("PASS");
        }else {
            double mim = 60 - notaFinal;
            System.out.println();
            System.out.println("FAILED");
            System.out.printf("MISSING %.2f", mim);
            System.out.print(" POINTS");
        }
    }
}
