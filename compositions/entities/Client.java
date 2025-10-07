package compositions.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
    String name;
    String email;
    Date birthData;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    Order order = new Order();
    public Client() {
    }

    public Client(String name, String email, Date birthData) {
        this.name = name;
        this.email = email;
        this.birthData = birthData;
    }

    @Override
    public String toString() {
        return "Client: " + name
                + " ("
                + sdf.format(birthData)
                + ")"
                +" - "
                + email;
    }
}
