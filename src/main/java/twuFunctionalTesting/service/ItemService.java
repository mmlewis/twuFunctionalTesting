package twuFunctionalTesting.service;

import twuFunctionalTesting.domain.Item;
import twuFunctionalTesting.domain.db.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private GenericRepository<Item> itemRepository;

    @Deprecated
    public ItemService() {}

    @Autowired
    public ItemService(@Qualifier("itemRepository") GenericRepository<Item> itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public List getAllItems() {
        return itemRepository.list();
    }

    @Transactional
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Transactional
    public Item findById(int id) {
        Item item = itemRepository.get(id);
        if(item == null) {
            item = new Item();
        }

        return item;
    }
}
