package com.switchfully.order.repository;

import com.switchfully.order.domain.item.Item;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private Map<String, Item> availableItems = new HashMap<>();

    public Item addItem(Item item) {
        availableItems.put(item.getId(), item);
        return item;
    }

    public Item getItemById(String id){
        return availableItems.get(id);
    }

    public List<Item> getAllItems() {
        return availableItems.values().stream().toList();
    }
}
