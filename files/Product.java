package files;

public class Product {
    private String name;
    private  Integer quantidade;
    private Double value;

    public Product() {
    }

    public Product(String name, Integer quantidade, Double value) {
        this.name = name;
        this.quantidade = quantidade;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValue() {
        return value;
    }
    
    public Double getTotal() {
        return getValue() * getQuantidade();
    }
}
