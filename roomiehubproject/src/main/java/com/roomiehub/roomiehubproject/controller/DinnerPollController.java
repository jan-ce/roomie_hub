package com.roomiehub.roomiehubproject.controller;

import com.roomiehub.roomiehubproject.model.DinnerPoll;
import com.roomiehub.roomiehubproject.service.DinnerPollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/dinner")
public class DinnerPollController {

    @Autowired
    private DinnerPollService dinnerPollService;

    @GetMapping
    public String showDinnerPollForm(Model model) {
        model.addAttribute("entry", new DinnerPoll());
        model.addAttribute("responses", dinnerPollService.getAllResponses());
        return "dinner";
    }
   
    @PostMapping
    public String submitPoll(@ModelAttribute DinnerPoll entry) {
        dinnerPollService.saveResponse(entry);
        return "redirect:/dinner";
    }
    @GetMapping("/delete/{id}")
    public String deletePollEntry(@PathVariable Long id) {
        dinnerPollService.deleteResponseById(id);
        return "redirect:/dinner";
    }
}
