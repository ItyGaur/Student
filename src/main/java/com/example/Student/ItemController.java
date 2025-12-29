package com.example.Student;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    private List<Item> items = new ArrayList<>();

    @GetMapping
    public List<Item> getAll() {
        return items;
    }

    @PostMapping
    public Item addItem(@RequestBody Item item) {
        items.add(item);
        return item;
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable int id, @RequestBody Item updatedItem) {
        for (Item item : items) {
            if (item.getId() == id) {
                item.setName(updatedItem.getName());
                return item;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@PathVariable int id) {
        boolean removed = items.removeIf(item -> item.getId() == id);

        if (removed) {
            return "Item deleted successfully!";
        } else {
            return "Item not found!";
        }
    }
}
