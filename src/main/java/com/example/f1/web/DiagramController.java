package com.example.f1.web;

import com.example.f1.repo.EredmenyRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DiagramController {

    private final EredmenyRepo eredmenyRepo;

    public DiagramController(EredmenyRepo eredmenyRepo) {
        this.eredmenyRepo = eredmenyRepo;
    }

    @GetMapping("/diagram")
    public String diagram(Model model) {
        var eredmenyek = eredmenyRepo.findAll();

        // Csapatonként átlagos helyezés számítása, null-ok és 0-ok kizárásával
        Map<String, Double> atlagok = eredmenyek.stream()
                .filter(e -> e.getHelyezes() != null && e.getHelyezes() > 0)
                .collect(Collectors.groupingBy(
                        e -> e.getCsapat(),
                        Collectors.averagingDouble(e -> e.getHelyezes())
                ));

        // Rendezett lista (legjobb csapatok elöl)
        var rendezett = atlagok.entrySet().stream()
                .filter(entry -> entry.getValue() > 0) // 🔹 csak pozitív átlagok
                .sorted(Map.Entry.comparingByValue())
                .toList();

        model.addAttribute("csapatok", rendezett.stream().map(Map.Entry::getKey).toList());
        model.addAttribute("atlagok", rendezett.stream().map(Map.Entry::getValue).toList());

        return "diagram";
    }

}
