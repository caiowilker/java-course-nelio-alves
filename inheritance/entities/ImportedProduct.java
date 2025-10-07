package inheritance.entities;

public class ImportedProduct extends Product{
    private Double customsFree;

    public ImportedProduct() {
        super();
    }

    public ImportedProduct(String name, double price, Double customsFree) {
        super(name, price);
        this.customsFree = customsFree;
    }

    public Double getCustomsFree() {
        return customsFree;
    }

    public void setCustomsFree(Double customsFree) {
        this.customsFree = customsFree;
    }

    @Override
    public String priceTag() {
        String mensagem = " $ "
                + String.format("%.2f", totalPrice())
                + " (Custom free: $ "
                + getCustomsFree() + ")";
        return mensagem;
    }

    public double totalPrice() {
        return getPrice() + getCustomsFree();
    }
}
