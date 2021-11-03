package com.OdkApprenant.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String admin_id;
    private String admin_nom;
    private String admin_prenom;
    private String admin_login;
    private String admin_password;


    public Admin() {
    }

    public String getAdmin_nom() {
        return admin_nom;
    }

    public void setAdmin_nom(String admin_nom) {
        this.admin_nom = admin_nom;
    }

    public String getAdmin_prenom() {
        return admin_prenom;
    }

    public void setAdmin_prenom(String admin_prenom) {
        this.admin_prenom = admin_prenom;
    }

    public String getAdmin_login() {
        return admin_login;
    }

    public void setAdmin_login(String admin_login) {
        this.admin_login = admin_login;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }
    public String getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(String admin_id) {
        this.admin_id = admin_id;
    }

}
