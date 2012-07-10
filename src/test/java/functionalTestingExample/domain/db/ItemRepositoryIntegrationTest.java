package functionalTestingExample.domain.db;

import functionalTestingExample.IntegrationTest;
import functionalTestingExample.domain.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ItemRepositoryIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GenericRepository<Item>  itemRepository;

    @Test
    public void shouldChooseUserByUserName() {
        addUserToRepository("Harry Potter");
        GenericRepository<Item> itemRepository =  new GenericRepository<Item>(sessionFactory, Item.class);
        Item item = itemRepository.findBy(Item.NAME_PROPERTY, "Harry Potter");
        assertThat(item.getName(), equalTo("Harry Potter"));
    }

    private void addUserToRepository(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "insert into Item (id, name, price, tax) values (27, '" + name + "' , 10.0, 12.0);";
        currentSession.createSQLQuery(sql).executeUpdate();
    }
    
}
