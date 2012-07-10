package functionalTestingExample.service;

import functionalTestingExample.domain.Item;
import functionalTestingExample.domain.db.GenericRepository;
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
}
