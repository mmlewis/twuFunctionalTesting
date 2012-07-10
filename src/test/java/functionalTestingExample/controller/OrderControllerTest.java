package functionalTestingExample.controller;

import functionalTestingExample.domain.Item;
import functionalTestingExample.service.ItemService;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Iterator;
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

        List<Item> items = new ArrayList<Item>();
        Item mockItem = mock(Item.class);
        items.add(mockItem);
        when(itemService.getAllItems()).thenReturn(items);

        ModelAndView modelAndView = orderController.create();
        Iterator<Item> retrievedItems = (Iterator<Item>) modelAndView.getModel().get("items");

        assertThat(retrievedItems.next(), is(mockItem));
    }
}
