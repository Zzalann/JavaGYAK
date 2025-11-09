package com.example.f1.web;

import com.example.f1.repo.EredmenyRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class DiagramController {
    private final EredmenyRepo eredmenyRepo;
    private final ObjectMapper objectMapper;

    public DiagramController(EredmenyRepo eredmenyRepo, ObjectMapper objectMapper) {
        this.eredmenyRepo = eredmenyRepo;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/diagram")
    public String diagram(Model m) throws Exception {
        var all = eredmenyRepo.findAll();

        Map<String, List<Map<String, Object>>> grouped = all.stream()
                .filter(e -> e.getDatum() != null) // csak ahol van dátum
                .collect(Collectors.groupingBy(
                        e -> e.getDatum().toString(),
                        Collectors.mapping(e -> {
                            Map<String, Object> map = new HashMap<>();
                            map.put("pilotaAz", e.getPilotaAz());
                            map.put("helyezes", e.getHelyezes());
                            map.put("csapat", e.getCsapat() != null ? e.getCsapat() : "Ismeretlen");
                            return map;
                        }, Collectors.toList())
                ));

        String json = objectMapper.writeValueAsString(grouped);
        m.addAttribute("rowsJson", json);
        return "diagram";
    }
}
