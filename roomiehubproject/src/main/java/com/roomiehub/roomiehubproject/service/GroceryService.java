package com.roomiehub.roomiehubproject.service;

import com.roomiehub.roomiehubproject.model.GroceryItem;
import com.roomiehub.roomiehubproject.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryService {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    // Get all grocery items
    public List<GroceryItem> getAllGroceries() {
        return groceryItemRepository.findAll();
    }


    // Get a grocery item by its id
    public GroceryItem getGroceryById(long id) {
        Optional<GroceryItem> optionalGrocery = groceryItemRepository.findById(id);
        return optionalGrocery.orElse(null);
    }

    // Save a grocery item (add or update)
    public void saveGrocery(GroceryItem grocery) {
        if (grocery.getId() != null && groceryItemRepository.existsById(grocery.getId())) {
            GroceryItem existing = groceryItemRepository.findById(grocery.getId()).orElse(null);
            if (existing != null) {
                existing.setName(grocery.getName());
                existing.setQuantity(grocery.getQuantity());
                existing.setCategory(grocery.getCategory());
                groceryItemRepository.save(existing);
            }
        } else {
            groceryItemRepository.save(grocery);
        }
        
    }


    // Delete a grocery item by id
    public void deleteGrocery(long id) {
        groceryItemRepository.deleteById(id);
    }
}
