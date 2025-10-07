package compositions.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    Date moment = new Date();
    OrderStatus status;
    List<OrderItem> item = new ArrayList<>();

   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(Date moment, OrderStatus status) throws ParseException {
        this.moment = moment;
        this.status = status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void addItem(OrderItem orderItem) { item.add(orderItem); }

    public void removeItem(OrderItem orderItem) {
        item.remove(orderItem);
    }

    public double total() {
        double tot = 0;
        for (OrderItem obj: item) {
            tot += obj.subTotal();
        }
        return tot;
    }

    @Override
    public String toString() {
        return "ORDER SUMMARY:\n"
                + "Order moment: " + sdf.format(moment)
                + "\n"
                + "Order status: " + status
                + "\n";
    }

    public List<OrderItem> getItem() {
        return item;
    }

}
