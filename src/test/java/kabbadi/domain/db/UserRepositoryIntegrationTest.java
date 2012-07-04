package kabbadi.domain.db;

import kabbadi.IntegrationTest;
import kabbadi.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserRepositoryIntegrationTest extends IntegrationTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private GenericRepository<User>  userRepository;

    @Test
    public void shouldChooseUserByUserName() {
        addUserToRepository("Bill");
        GenericRepository<User> userRepository =  new GenericRepository<User>(sessionFactory, User.class);
        User actualUser = userRepository.findBy(User.NAME_PROPERTY, "Bill");
        assertThat(actualUser.getName(), equalTo("Bill"));
    }

    private void addUserToRepository(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        String sql = "insert into User (id, name) values (27, '" + name + "');";
        currentSession.createSQLQuery(sql).executeUpdate();
    }
    
}
