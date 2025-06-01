package com.roomiehub.roomiehubproject.controller;

import com.roomiehub.roomiehubproject.model.GroceryItem;
import com.roomiehub.roomiehubproject.repository.GroceryItemRepository;
import com.roomiehub.roomiehubproject.service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/groceries")
public class GroceryController {

    @Autowired
    private GroceryService groceryService;
    @Autowired
    private GroceryItemRepository groceryItemRepository; 

    // Display the list of groceries
    @GetMapping
    public String showGroceries(Model model) {
    	 model.addAttribute("grocery", new GroceryItem()); // Needed for the form
    	    model.addAttribute("groceries", groceryItemRepository.findAll()); // Needed for the table
    	    return "groceries"; // Matches groceries.html This should match the "groceries.html" template in src/main/resources/templates
    }

    // Show form to add a new grocery item
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("grocery", new GroceryItem());
        return "add-grocery"; // This should match the "add-grocery.html" template
    }

    // Save a new grocery item
    @PostMapping("/save")
    public String saveGrocery(@ModelAttribute("grocery") GroceryItem grocery) {
        groceryService.saveGrocery(grocery);
        return "redirect:/groceries"; // Redirect to the list of groceries after save
    }

    // Show form to edit an existing grocery item
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        GroceryItem grocery = groceryService.getGroceryById(id);
        model.addAttribute("grocery", grocery);
        model.addAttribute("groceries", groceryItemRepository.findAll()); // Show table too
        return "groceries"; // Use the same template as the form
    }
    // Update the grocery item
    @PostMapping("/update")
    public String updateGrocery(@ModelAttribute("grocery") GroceryItem grocery) {
        groceryService.saveGrocery(grocery);
        return "redirect:/groceries"; // Redirect to the list of groceries after update
    }

    // Delete a grocery item
    @GetMapping("/delete/{id}")
    public String deleteGrocery(@PathVariable("id") long id) {
        groceryService.deleteGrocery(id);
        return "redirect:/groceries"; // Redirect to the list of groceries after delete
    }
}
