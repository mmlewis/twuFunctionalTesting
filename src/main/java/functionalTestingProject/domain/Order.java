package functionalTestingProject.domain;

import lombok.Setter;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
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

    @Email
    @Column
    private String email;

    @Column
    private double total;

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
}
