package functionalTestingProject.controller;

import functionalTestingProject.domain.Item;
import functionalTestingProject.domain.Order;
import functionalTestingProject.service.ItemService;
import functionalTestingProject.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    private OrderService orderService = mock(OrderService.class);
    private ItemService itemService = mock(ItemService.class);
    private OrderController orderController;

    @Before
    public void given() {
        orderController = new OrderController(orderService, itemService);
    }

    @Test
    public void shouldOpenCreateOrderPage() {
        ModelAndView orderPage = orderController.newOrder();

        assertThat(orderPage.getViewName(), is("/order/new"));
    }
}
