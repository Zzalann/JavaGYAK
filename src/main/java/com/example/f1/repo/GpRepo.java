package com.example.f1.repo;
import com.example.f1.model.Gp;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;

public interface GpRepo extends JpaRepository<Gp, LocalDate> { }
