package com.example.f1;

import com.example.f1.model.User;
import com.example.f1.repo.UserRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Forma1Application {

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(Forma1Application.class, args);
    }

    @Bean
    public CommandLineRunner createAdmin(UserRepo userRepo, PasswordEncoder encoder) {
        return args -> {
            if (userRepo.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(encoder.encode("admin"));
                admin.setRole("ADMIN");
                userRepo.save(admin);
            }
        };
    }
}
