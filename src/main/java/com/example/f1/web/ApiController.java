package com.example.f1.web;

import com.example.f1.model.Eredmeny;
import com.example.f1.model.Pilota;
import com.example.f1.repo.EredmenyRepo;
import com.example.f1.repo.PilotaRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final PilotaRepo pilotaRepo;
    private final EredmenyRepo eredmenyRepo;

    public ApiController(PilotaRepo p, EredmenyRepo e) {
        this.pilotaRepo = p; this.eredmenyRepo = e;
    }

    @GetMapping("/pilota")
    public List<Pilota> allPilota() { return pilotaRepo.findAll(); }

    @PostMapping("/pilota")
    public Pilota savePilota(@RequestBody Pilota p) { return pilotaRepo.save(p); }

    @GetMapping("/eredmeny")
    public List<Eredmeny> allEredmeny() { return eredmenyRepo.findAll(); }
}
