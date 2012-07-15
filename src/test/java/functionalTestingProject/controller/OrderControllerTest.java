package functionalTestingProject.controller;

import functionalTestingProject.domain.Item;
import functionalTestingProject.service.ItemService;
import functionalTestingProject.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

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

        assertThat(orderPage.getViewName(), is("order/new"));
    }

    @Test
    public void shouldAddItemsToModel() {
        List<Item> orders = new ArrayList<Item>();
        Item mockOrder = mock(Item.class);
        orders.add(mockOrder);
        when(itemService.getAllItems()).thenReturn(orders);

        ModelAndView modelAndView = orderController.newOrder();
        List<Item> retrievedItems = (List<Item>) modelAndView.getModel().get("items");

        assertThat(retrievedItems.size(), is(1));
    }
}
