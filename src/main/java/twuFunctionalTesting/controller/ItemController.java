package twuFunctionalTesting.controller;

import twuFunctionalTesting.domain.Item;
import twuFunctionalTesting.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping(value = ("item"), method = GET)
    public @ResponseBody String show(@RequestParam("item_id") String itemId) {
//        return "{\"price\": \"$5\", \"tax\": \"$0.24\"}";
        Item item = itemService.findById(Integer.parseInt(itemId));
        return item.asJson();
    }
}
