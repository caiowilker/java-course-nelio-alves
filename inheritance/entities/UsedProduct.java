package inheritance.entities;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{
    private Date manufactureDate;

    SimpleDateFormat sfd = new SimpleDateFormat("dd/MM/yyyy");
    public UsedProduct() {
        super();
    }

    public UsedProduct(String name, double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        String mensagem = "(used)"
                + " $ " + String.format("%.2f", getPrice())
                + " (Manufacture date: $ "
                + sfd.format(getManufactureDate())
                + ")";
        return mensagem;


    }


}
