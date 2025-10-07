package bank;
public class Util {
    private Model account;

    public Util(Model account) {
        this.account = account;
    }

    public void deposit(double valor) {
        valor = valor + account.getSaldo();
        account.setSaldo(valor);
    }

    public void sacar(double valor) {
        valor = account.getSaldo() - valor - account.getTax();
        account.setSaldo(valor);
    }
}
