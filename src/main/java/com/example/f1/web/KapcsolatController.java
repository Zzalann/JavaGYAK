package com.example.f1.web;

import com.example.f1.model.Mess;
import com.example.f1.repo.MessRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class KapcsolatController {

    private final MessRepo messRepo;

    public KapcsolatController(MessRepo messRepo) {
        this.messRepo = messRepo;
    }

    @GetMapping("/kapcsolat")
    public String kapcsolatForm(Model model) {
        model.addAttribute("message", new Mess());
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat")
    public String sendMessage(@ModelAttribute("message") Mess message, Model model) {
        messRepo.save(message);
        model.addAttribute("success", true);
        return "kapcsolat";
    }

    @GetMapping("/uzenetek")
    public String listMessages(Model model) {
        model.addAttribute("messages", messRepo.findAll());
        return "uzenetek";
    }
}
