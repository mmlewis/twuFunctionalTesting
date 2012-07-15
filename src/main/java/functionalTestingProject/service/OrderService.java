package functionalTestingProject.service;

import functionalTestingProject.domain.Order;
import functionalTestingProject.domain.db.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {

    private GenericRepository<Order> orderRepository;

    @Deprecated
    public OrderService() {}

    @Autowired
    public OrderService(@Qualifier("orderRepository") GenericRepository<Order> orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    public List getAllItems() {
        return orderRepository.list();
    }

    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Order find(int id) {
        Order order = orderRepository.get(id);
        if(order == null) {
            order = new Order();
        }

        return order;
    }
}
