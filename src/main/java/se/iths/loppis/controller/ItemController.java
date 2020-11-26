package se.iths.loppis.controller;

import org.springframework.web.bind.annotation.*;
import se.iths.loppis.entity.Item;
import se.iths.loppis.service.ItemService;

import java.util.Optional;

@RestController
@RequestMapping("/item")
public class ItemController {


    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/create")
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    @GetMapping("/findall")
    public Iterable<Item> findAllItems() {
        return itemService.findAllItems();
    }

    @GetMapping("/id/{id}")
    public Optional<Item> findItemById(@PathVariable Long id) {
        return itemService.findItemById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
    }

    @GetMapping("/findbyuser/{id}")
    public Iterable<Item> getAllItemsByUser(@PathVariable Long id) {
        return itemService.findItemsByUserId(id);
    }

    @GetMapping("/findallitemsbyuser")
    Iterable<Item> findAllItemsByUser() {
        return itemService.findAllByUser();
    }

}
