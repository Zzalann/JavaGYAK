package com.example.f1.repo;

import com.example.f1.model.Eredmeny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EredmenyRepo extends JpaRepository<Eredmeny, Long> {

    @Query("SELECT e FROM Eredmeny e WHERE str(e.datum) LIKE concat(:datum, '%')")
    List<Eredmeny> findByDatum(LocalDate datum);
    List<Eredmeny> findByPilotaAz(Integer pilotaAz);
}
