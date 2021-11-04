package com.OdkApprenant.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Formateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long form_id;

    private String form_nom;
    private String form_prenom;
    private String form_email;


    public Long getForm_id() {
        return form_id;
    }

    public void setForm_id(Long form_id) {
        this.form_id = form_id;
    }

    public String getForm_nom() {
        return form_nom;
    }

    public void setForm_nom(String form_nom) {
        this.form_nom = form_nom;
    }

    public String getForm_prenom() {
        return form_prenom;
    }

    public void setForm_prenom(String form_prenom) {
        this.form_prenom = form_prenom;
    }

    public String getForm_email() {
        return form_email;
    }

    public void setForm_email(String form_email) {
        this.form_email = form_email;
    }

    @Override
    public String toString() {
        return "Formateur{" +
                "form_id='" + form_id + '\'' +
                ", form_nom='" + form_nom + '\'' +
                ", form_prenom='" + form_prenom + '\'' +
                ", form_email='" + form_email + '\'' +
                '}';
    }
}
