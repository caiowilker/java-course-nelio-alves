package compositions.entities;

public class OrderItem extends Product{
    Integer quantity;
    Double price;

    public OrderItem(Integer quantity, Double price, Product product) {
        this.quantity = quantity;
        this.price = price;
        this.name = product.name;
    }

    public double subTotal() {
        return quantity * price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
