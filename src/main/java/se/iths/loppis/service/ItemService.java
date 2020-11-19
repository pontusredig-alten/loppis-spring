package se.iths.loppis.service;

import org.springframework.stereotype.Service;
import se.iths.loppis.entity.Item;
import se.iths.loppis.repository.ItemRepository;

import java.util.Optional;

@Service
public class ItemService {


    private ItemRepository itemRepository;


    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        Optional<Item> foundItem = itemRepository.findById(id);
        itemRepository.deleteById(foundItem.get().getId());
    }

    public Optional<Item> findItemById(Long id) {
        return itemRepository.findById(id);
    }

    public Iterable<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Iterable<Item> findItemsByUserId(Long id) {
        return itemRepository.findItemsByUserId(id);
    }

}
