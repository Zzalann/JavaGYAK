package com.example.f1.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "eredmeny")
public class Eredmeny {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate datum;

    @Column(name = "pilotaaz")
    private Integer pilotaAz;

    private Integer helyezes;
    private String hiba;
    private String csapat;
    private String tipus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "datum", referencedColumnName = "datum", insertable = false, updatable = false)
    private Gp gp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pilotaaz", referencedColumnName = "az", insertable = false, updatable = false)
    private Pilota pilota;

    // getters/setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public LocalDate getDatum() { return datum; }
    public void setDatum(LocalDate datum) { this.datum = datum; }
    public Integer getPilotaAz() { return pilotaAz; }
    public void setPilotaAz(Integer pilotaAz) { this.pilotaAz = pilotaAz; }
    public Integer getHelyezes() { return helyezes; }
    public void setHelyezes(Integer helyezes) { this.helyezes = helyezes; }
    public String getHiba() { return hiba; }
    public void setHiba(String hiba) { this.hiba = hiba; }
    public String getCsapat() { return csapat; }
    public void setCsapat(String csapat) { this.csapat = csapat; }
    public String getTipus() { return tipus; }
    public void setTipus(String tipus) { this.tipus = tipus; }
    public Gp getGp() { return gp; }
    public Pilota getPilota() { return pilota; }
}
