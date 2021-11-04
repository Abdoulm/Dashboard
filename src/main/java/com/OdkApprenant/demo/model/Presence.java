package com.OdkApprenant.demo.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Presence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long presence_id;

    @Temporal(TemporalType.DATE)
    Date Date_of_day;

    @Temporal(TemporalType.TIME)
    Date heure_arriver;

    @Temporal(TemporalType.TIME)
    Date heure_depart;

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

    public Date getDate_of_day() {
        return Date_of_day;
    }

    public void setDate_of_day(Date date_of_day) {
        Date_of_day = date_of_day;
    }

    public Date getHeure_arriver() {
        return heure_arriver;
    }

    public void setHeure_arriver(Date heure_arriver) {
        this.heure_arriver = heure_arriver;
    }

    public Date getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(Date heure_depart) {
        this.heure_depart = heure_depart;
    }

    public Apprenant getAppr() {
        return appr;
    }

    public void setAppr(Apprenant appr) {
        this.appr = appr;
    }
}
