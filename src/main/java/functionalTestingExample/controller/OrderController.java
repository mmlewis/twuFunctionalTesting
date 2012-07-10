package functionalTestingExample.controller;

import functionalTestingExample.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List items = itemService.getAllItems();

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("items", items.iterator());

        return new ModelAndView("/order/index", model);
    }
}
