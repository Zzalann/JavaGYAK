package com.example.f1.repo;

import com.example.f1.model.Mess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessRepo extends JpaRepository<Mess, Long> {
}
