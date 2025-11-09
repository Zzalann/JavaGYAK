package com.example.f1.web;

import com.example.f1.model.User;
import com.example.f1.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String username,
                                  @RequestParam String password,
                                  RedirectAttributes redirectAttributes) {

        if (userRepo.findByUsername(username).isPresent()) {
            redirectAttributes.addFlashAttribute("error", "A felhasználónév már létezik!");
            return "redirect:/register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);

        redirectAttributes.addFlashAttribute("success", "✅ Sikeres regisztráció! Jelentkezz be az adataiddal.");
        return "redirect:/login";
    }
}
