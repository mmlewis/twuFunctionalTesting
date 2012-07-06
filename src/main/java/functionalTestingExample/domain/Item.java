package functionalTestingExample.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;

    public static final String NAME_PROPERTY = "name";

    private String name;

    @Deprecated
    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
