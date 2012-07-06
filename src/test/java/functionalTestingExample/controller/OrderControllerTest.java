package functionalTestingExample.controller;

import functionalTestingExample.domain.Item;
import functionalTestingExample.service.ItemService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class OrderControllerTest {

    private ItemService itemService = mock(ItemService.class);

    @Test
    public void shouldOpenCreateOrderPage() {
        OrderController orderController = new OrderController(itemService);

        ModelAndView orderPage = orderController.create();

        assertThat(orderPage.getViewName(), is("/order/index"));
    }

    @Test
    public void shouldCallTheItemsServiceToGetAllItems() {
        OrderController orderController = new OrderController(itemService);

        orderController.create();

        verify(itemService, times(1)).getAllItems();
    }

    @Test
    public void shouldAddItemsToModel() {
        OrderController orderController = new OrderController(itemService);

        List items = new ArrayList();
        items.add(mock(Item.class));
        items.add(mock(Item.class));
        when(itemService.getAllItems()).thenReturn(items);

        ModelAndView modelAndView = orderController.create();
        List actualItems = (List) modelAndView.getModel().get("items");

        assertThat(actualItems.size(), is(2));
    }
}
