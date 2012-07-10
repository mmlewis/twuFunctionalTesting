package functionalTestingExample.domain;

import javax.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public static final String NAME_PROPERTY = "name";

    private String name;
    private double price;
    private double tax;

    @Deprecated
    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name, double price, double tax) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getTax() {
        return tax;
    }
}
