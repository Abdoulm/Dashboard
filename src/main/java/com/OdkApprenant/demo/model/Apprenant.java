/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import javax.persistence.*;


@Entity
public class Apprenant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idApprenant;
    private String nom;
    private String prenom;
    private String heure_arrive_apprenant;
    private String heure_depart_apprenant;
    private String age;
    private String tel;
    private String email;
    private String login;
    private String password;
    private String genre;
    private  ApprenantStatus apprenantStatus;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateCreation;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateModification;


    public Apprenant() {
        super();
    }

    public Apprenant(String nom, String prenom, String age, String tel, String email, String login, String password, String genre, ApprenantStatus apprenantStatus, Date dateCreation, Date dateModification) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.tel = tel;
        this.email = email;
        this.login = login;
        this.password = password;
        this.genre = genre;
        this.apprenantStatus = apprenantStatus;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
    }
    
    
    
    
    
    public Long getIdApprenant() {
        return idApprenant;
    }

    public void setIdApprenant(Long idApprenant) {
        this.idApprenant = idApprenant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ApprenantStatus getApprenantStatus() {
        return apprenantStatus;
    }

    public void setApprenantStatus(ApprenantStatus apprenantStatus) {
        this.apprenantStatus = apprenantStatus;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public String getHeure_arrive_apprenant() {
        return heure_arrive_apprenant;
    }

    public void setHeure_arrive_apprenant(String heure_arrive_apprenant) {
        this.heure_arrive_apprenant = heure_arrive_apprenant;
    }

    public String getHeure_depart_apprenant() {
        return heure_depart_apprenant;
    }

    public void setHeure_depart_apprenant(String heure_depart_apprenant) {
        this.heure_depart_apprenant = heure_depart_apprenant;
    }


    @Override
    public String toString() {
        return "Apprenant{" + "idApprenant=" + idApprenant + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", tel=" + tel + ", email=" + email + ", login=" + login + ", password=" + password + ", genre=" + genre + ", apprenantStatus=" + apprenantStatus + ", dateCreation=" + dateCreation + ", dateModification=" + dateModification + '}';
    }
    
    
    
}
