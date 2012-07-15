package functionalTestingProject.controller;

import functionalTestingProject.domain.Item;
import functionalTestingProject.domain.Order;
import functionalTestingProject.service.ItemService;
import functionalTestingProject.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private OrderService orderService;
    private ItemService itemService;

    @InitBinder
    public void bind(WebDataBinder webDataBinder) {
        webDataBinder.registerCustomEditor(Item.class, "item", new ItemPropertyEditor());
    }

    @Autowired
    public OrderController(OrderService orderService, ItemService itemService) {
        this.orderService = orderService;
        this.itemService = itemService;
    }

    @RequestMapping(value = {"/", ""}, method = GET)
    public ModelAndView newOrder() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("order", new Order());
        model.put("items", itemService.getAllItems());

        return new ModelAndView("/order/new", model);
    }

    @RequestMapping(value = "/create", method = POST)
    public ModelAndView create(@RequestParam("itemId") Integer itemId, @ModelAttribute Order order, BindingResult bindingResult) throws IOException {
        order.setItem(itemService.findById(itemId));
        orderService.save(order);

        HashMap<String, Object> model = new HashMap<String, Object>();
        model.put("orderId", order.getId());
        
        return new ModelAndView(new RedirectView("/functionalTestingProject/order/show"), model);
    }

    @RequestMapping(value = "/show", method = GET)
    public ModelAndView show(@RequestParam("orderId") Integer orderId) {
        Order savedOrder = orderService.find(orderId);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("order", savedOrder);

        return new ModelAndView("/order/show", model);
    }
}
