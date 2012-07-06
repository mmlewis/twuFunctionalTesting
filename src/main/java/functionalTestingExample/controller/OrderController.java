package functionalTestingExample.controller;

import functionalTestingExample.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class OrderController {

    private ItemService itemService;

    @Autowired
    public OrderController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = "/order", method = GET)
    public ModelAndView create() {
        ModelAndView modelAndView = new ModelAndView("/orders");

        List items = itemService.getAllItems();
        modelAndView.getModel().put("items", items);

        return modelAndView;
    }
}
