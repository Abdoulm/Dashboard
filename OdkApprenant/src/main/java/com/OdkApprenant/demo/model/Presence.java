package com.OdkApprenant.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;


@Entity
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long presence_id;


    LocalDate date;


    LocalTime heure_arriver;


    LocalTime heure_depart;

    @ManyToOne
    private Apprenant appr;


    public Presence() {
    }

    public Long getPresence_id() {
        return presence_id;
    }

    public void setPresence_id(Long presence_id) {
        this.presence_id = presence_id;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure_arriver() {
        return heure_arriver;
    }

    public void setHeure_arriver(LocalTime heure_arriver) {
        this.heure_arriver = heure_arriver;
    }

    public LocalTime getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(LocalTime heure_depart) {
        this.heure_depart = heure_depart;
    }

    public Apprenant getAppr() {
        return appr;
    }

    public void setAppr(Apprenant appr) {
        this.appr = appr;
    }
}
