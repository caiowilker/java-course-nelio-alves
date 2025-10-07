package cotacao;

public class CurrencyConverter {
    public static final float iof = 1.06F;
    public static float price;
    public static float quantidade;

    public static float convert() {
        return price * quantidade * iof;
    }
}
