package inheritance.entities;

public class Product {
    private String name;
    private Double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String priceTag() {
        String mensagem = " $ "
                + String.format("%.2f", getPrice());
        return mensagem;
    }
}
