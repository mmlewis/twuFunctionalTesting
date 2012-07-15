package functionalTestingProject.domain.db;

import functionalTestingProject.IntegrationTest;
import functionalTestingProject.domain.Item;
import functionalTestingProject.domain.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class OrderRepositoryIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GenericRepository<Order> orderRepository;

    @Test
    public void shouldChooseByName() {
        addOrderToRepository("Harry Potter");
        GenericRepository<Order> orderRepository =  new GenericRepository<Order>(sessionFactory, Order.class);
        Order order = orderRepository.findBy(Order.NAME_PROPERTY, "Harry Potter");
        assertThat(order.getName(), equalTo("Harry Potter"));
    }

    @Test
    public void shouldSaveOrderToRepository() {
        GenericRepository<Order> orderRepository =  new GenericRepository<Order>(sessionFactory, Order.class);
        Order savedOrder = orderRepository.save(new Order(3, "Some name", "email@email.com", 10.0));

        assertThat(savedOrder.getName(), equalTo("Some name"));
    }

    private void addOrderToRepository(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "insert into orders (id, name, email, total) values (27, '" + name + "' , 'test@email.com', '10.0');";
        currentSession.createSQLQuery(sql).executeUpdate();
    }
    
}
