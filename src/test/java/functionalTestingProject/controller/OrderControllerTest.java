package functionalTestingProject.controller;

import functionalTestingProject.domain.Item;
import functionalTestingProject.domain.Order;
import functionalTestingProject.service.ItemService;
import functionalTestingProject.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
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

    @Test
    public void shouldCallOrderServiceToSaveOrder() throws IOException {
        Order order = new Order(1, "name", "email", 1.0);

        orderController.create(1, order);

        verify(orderService, times(1)).save(order);
    }

    @Test
    public void shouldRedirectToShowOrder() throws IOException {
        Order order = new Order(1, "name", "email", 1.0);
        ModelAndView modelAndView = orderController.create(1, order);
        assertThat(((RedirectView) modelAndView.getView()).getUrl(), equalTo("/functionalTestingProject/order/show"));
    }

    @Test
    public void shouldGetOrderFromOrderServiceToShow() {
        Order mockOrder = mock(Order.class);
        when(orderService.find(3)).thenReturn(mockOrder);
        ModelAndView modelAndView = orderController.show(3);
        assertThat((Order) modelAndView.getModel().get("order"), equalTo(mockOrder));
    }
}
