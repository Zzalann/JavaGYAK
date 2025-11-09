package com.example.f1.web;

import com.example.f1.model.Message;
import com.example.f1.repo.MessageRepo;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class KapcsolatController {
    private final MessageRepo repo;
    public KapcsolatController(MessageRepo repo) { this.repo = repo; }

    @GetMapping("/kapcsolat")
    public String form(Model m) {
        m.addAttribute("msg", new Message());
        return "kapcsolat";
    }

    @PostMapping("/kapcsolat")
    public String submit(@Valid @ModelAttribute("msg") Message msg, BindingResult br) {
        if (br.hasErrors()) return "kapcsolat";
        repo.save(msg);
        return "redirect:/";
    }

    @GetMapping("/uzenetek")
    public String uzenetek(Model m) {
        m.addAttribute("msgs", repo.findAllByOrderByCreatedAtDesc());
        return "uzenetek";
    }
}
