package functionalTestingExample.domain.db;

import functionalTestingExample.IntegrationTest;
import functionalTestingExample.domain.Item;
import functionalTestingExample.domain.User;
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
        addUserToRepository("To Kill A Mockingbird");
        GenericRepository<Item> itemRepository =  new GenericRepository<>(sessionFactory, Item.class);
        Item item = itemRepository.findBy(Item.NAME_PROPERTY, "To Kill A");
        assertThat(item.getName(), equalTo("To Kill A Mockingbird"));
    }

    private void addUserToRepository(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "insert into User (id, name) values (27, '" + name + "');";
        currentSession.createSQLQuery(sql).executeUpdate();
    }
    
}
