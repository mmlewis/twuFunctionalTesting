package functionalTestingProject.domain;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ORDERS")
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

    @Deprecated
    public Order() {}

    public Order(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
