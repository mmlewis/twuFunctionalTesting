package twuFunctionalTesting.domain;

import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ORDERS")
@Setter
public class Order implements Serializable {
    public static String NAME_PROPERTY = "name";
    public static String ID = "id";

    @GeneratedValue
    @Id
    private int id;

    @NotEmpty
    @Column
    private String name;

    @NotEmpty
    @Email
    @Column
    private String email;

    @NotNull
    @Column
    private double total;

    @ManyToOne(cascade = CascadeType.ALL)
    private Item item;

    @Deprecated
    public Order() {}

    public Order(int id, String name, String email, double total) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getTotal() {
        return total;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public int getId() {
        return id;
    }
}
