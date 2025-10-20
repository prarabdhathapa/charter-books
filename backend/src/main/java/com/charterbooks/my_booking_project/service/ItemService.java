package com.charterbooks.my_booking_project.service;
//Acts as "business" bridge between repo and controller
import com.charterbooks.my_booking_project.model.Item;
import com.charterbooks.my_booking_project.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    public Item getItemByID(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id).orElse(null);
        if (item == null) return null;

        item.setName(itemDetails.getName());
        item.setType(itemDetails.getType());
        item.setDescription(itemDetails.getDescription());
        item.setPrice(itemDetails.getPrice());
        item.setTimeSlot(itemDetails.getTimeSlot());
        item.setEnabled(itemDetails.isEnabled());

        return itemRepository.save(item);
    }

    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
