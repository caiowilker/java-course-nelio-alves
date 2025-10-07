package employee;


public class Employee {
    public String name;
    public double grossSaralary;
    public double tax;


    public double netSalary() {
        this.grossSaralary = grossSaralary - tax;
        return grossSaralary;
    }

    public double increaseSalary(double percentage) {
       return ((percentage * grossSaralary) / 100) + grossSaralary;
    }


}
