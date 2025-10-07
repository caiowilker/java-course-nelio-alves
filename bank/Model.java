package bank;

public class Model {
    private int numConta;
    private String name;
    private double saldo;
    private double tax = 5;
    private String initial;

    public Model() {
    }

    public Model(int numConta, String name, double saldo, int tax) {
        this.numConta = numConta;
        this.name = name;
        this.saldo = saldo;
        this.tax = tax;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    @Override
    public String toString() {
        return "Updated account data: \n" +
                "Account " + numConta +
                ", Holder: " + name
                + ", Balance: $ "
                + String.format("%.2f" , saldo);
    }
}
