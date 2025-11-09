package com.example.f1.web;

import com.example.f1.repo.GpRepo;
import com.example.f1.repo.PilotaRepo;
import com.example.f1.repo.EredmenyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdatbazisController {

    @Autowired
    private PilotaRepo pilotaRepo;

    @Autowired
    private GpRepo gpRepo;

    @Autowired
    private EredmenyRepo eredmenyRepo;

    @GetMapping("/adatbazis")
    public String adatbazis(Model model) {
        model.addAttribute("pilotak", pilotaRepo.findAll());
        model.addAttribute("gpLista", gpRepo.findAll());
        model.addAttribute("eredmenyek", eredmenyRepo.findAll());
        return "adatbazis";
    }
}

