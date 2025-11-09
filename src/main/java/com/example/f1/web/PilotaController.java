package com.example.f1.web;

import com.example.f1.model.Pilota;
import com.example.f1.repo.PilotaRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pilota")
public class PilotaController {
    private final PilotaRepo repo;
    public PilotaController(PilotaRepo repo) { this.repo = repo; }

    @GetMapping
    public String list(Model m) {
        m.addAttribute("list", repo.findAll());
        return "pilota/list";
    }

    @GetMapping("/uj")
    public String uj(Model m) {
        m.addAttribute("p", new Pilota());
        return "pilota/form";
    }

    @PostMapping("/ment")
    public String ment(@ModelAttribute("p") Pilota p) {
        repo.save(p);
        return "redirect:/pilota";
    }

    @GetMapping("/szerk/{az}")
    public String szerk(@PathVariable Integer az, Model m) {
        Pilota p = repo.findById(az).orElseThrow();
        m.addAttribute("p", p);
        return "pilota/form";
    }

    @PostMapping("/torol/{az}")
    public String torol(@PathVariable Integer az) {
        repo.deleteById(az);
        return "redirect:/pilota";
    }
}
