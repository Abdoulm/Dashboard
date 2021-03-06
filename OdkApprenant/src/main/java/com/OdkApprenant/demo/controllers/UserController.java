/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.controllers;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.model.Formateur;
import com.OdkApprenant.demo.model.Presence;
import com.OdkApprenant.demo.repositories.ApprenantRepository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.OdkApprenant.demo.repositories.FormateurRepository;
import com.OdkApprenant.demo.repositories.PresenceRepository;
import com.OdkApprenant.demo.services.ApprenantServices;
import com.OdkApprenant.demo.services.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    ApprenantRepository apprenantRepo;

    SimpleDateFormat formatter = new SimpleDateFormat("yyy/MM/dd");

    @Autowired
    FormateurRepository formateurRepository;

    @Autowired
    PresenceRepository presenceRepository;
    
    @Autowired
    ServiceImp serviceImp;

    @Autowired
    ApprenantServices apprenantServices;

    Date date_today;


    @GetMapping("")
    public String getHomePage(){

        return "index";
    }


    //-----------------------  Apprenants -----------------------------------------------

    @GetMapping("/apprenant/all")
    public List<Apprenant> getAllApprenant(){
    List<Apprenant> apprenantList = new ArrayList<Apprenant>();
    Iterable<Apprenant> iterable = serviceImp.getAllApprenants();
    iterable.forEach(apprenantList::add);
    
    return apprenantList;
    }
    

    @PostMapping("/apprenant/add")
    public Apprenant ajouterApprenant(@RequestBody Apprenant apprenant){
        return serviceImp.saveApprenant(apprenant);
    }
    
    @DeleteMapping("/apprenant/delete/{id}")
    public void suprimerApprenant(@PathVariable(value = "id") Long id){
        serviceImp.deleteApprenantById(id);
    }

     @GetMapping("/apprenant/{id}")
     public ResponseEntity<Apprenant> getApprenantByeId(@PathVariable(value = "id") Long id){
         Optional<Apprenant> apprenant = apprenantRepo.findById(id);
         return apprenant.isPresent() ? new ResponseEntity<Apprenant> (apprenant.get(), HttpStatus.OK) 
                 : new ResponseEntity("Vos donnees ne sont pas present!!!!", HttpStatus.NOT_FOUND);
         
    
    }
   
    @PutMapping("/apprenant/{id}")
    public ResponseEntity<Apprenant> modifierApprenant(@PathVariable(value = "id") Long id,
            @RequestBody Apprenant modifier_apprenant){
        Optional<Apprenant> apprenant = apprenantRepo.findById(id);
        if (apprenant.isPresent()){
            Apprenant apprenant1 = apprenant.get();
            apprenant1.setNom(modifier_apprenant.getNom());
            apprenant1.setPrenom(modifier_apprenant.getPrenom());
            apprenant1.setAge(modifier_apprenant.getAge());
            apprenant1.setTel(modifier_apprenant.getTel());
            apprenant1.setEmail(modifier_apprenant.getEmail());
            apprenant1 = apprenantRepo.save(apprenant1);
            
            return ResponseEntity.ok().body(apprenant1);
        }else {
            return ResponseEntity.notFound().build();
                    
        }
    }


    //-----------------------  Formateur -----------------------------------------------


    @GetMapping("all/formateur")
    public ResponseEntity<List<Formateur>> getAllFormateur(){
        List<Formateur> formateurList = serviceImp.getAllFormateur();
        return new ResponseEntity<>(formateurList, HttpStatus.OK);
    }

    @PostMapping("add/formateur")
    public ResponseEntity<Formateur> addFormateur(@RequestBody Formateur formateur){
        Formateur formateur1 = serviceImp.saveFormateur(formateur);
        return new ResponseEntity<>(formateur1, HttpStatus.CREATED);
    }

    @PutMapping("update/formateur/{id}")
    public ResponseEntity<Formateur> updateFomateur(@PathVariable(value = "id") Long id,
                                                       @RequestBody Formateur modifier_formateur){
        Optional<Formateur> formateur = formateurRepository.findById(id);
        if (formateur.isPresent()){
            Formateur formateur1 = formateur.get();
            formateur1.setForm_nom(modifier_formateur.getForm_nom());
            formateur1.setForm_prenom(modifier_formateur.getForm_prenom());
            formateur1.setForm_email(modifier_formateur.getForm_email());

            formateur1 = formateurRepository.save(formateur1);

            return ResponseEntity.ok().body(formateur1);
        }else {
            return ResponseEntity.notFound().build();

        }
    }


    //----------------------- Liste Presence -----------------------------------------------


    //aFFICHER LA LLISTE DE TOUS LES PRESEHTS
    @GetMapping("/presence")
    public ResponseEntity<List<Presence>> getAllPresence(){
        List<Presence> presenceList = serviceImp.getAllPresence();
        return new ResponseEntity<>(presenceList, HttpStatus.OK);
    }

    //AJOUTER UNE PRESENCE DANS LA LISTE
    @PostMapping("add/presence")
    public ResponseEntity<Presence> addFormateur(@RequestBody Presence presence){
        Presence presence1 = serviceImp.add_to_liste(presence);
        return new ResponseEntity<>(presence1, HttpStatus.CREATED);
    }

    //Avoir La liste de presence Par La Date du jour LocalTimeDate
    @GetMapping("/presence/today")
    public List<Presence> getTodayPresenceListe(){
        return serviceImp.getPresenceList(LocalDate.now());
    }

    //Get presence list by date
    @GetMapping("/presence/date={date}")
    public List<Presence> getTodayPresenceList(
            @PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date){
        return this.serviceImp.getPresenceList(date);
    }

    //Get presence list by a week
    @GetMapping("/presence/week={year}-{month}-{day}")
    public List<Presence> getListByWeek(
            @PathVariable("year") int year,
            @PathVariable("month") int month,
            @PathVariable("day") int day){

        return this.serviceImp.getPresenceList(year, month, day);
    }

    //Get presence list by month
    @GetMapping("/presence/month={year}-{month}")
    public List<Presence> getMonthPresenceList(
            @PathVariable("year") int year,
            @PathVariable("month") int month)
    {
        return this.serviceImp.getPresenceList(year, month);
    }

    //Get presence list between two periodes of time
    @GetMapping("/presence/entre/{start}&{end}")
    public List<Presence> getPresenceListBetween(
            @PathVariable("start") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate start,
            @PathVariable("end") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate end){
        return this.serviceImp.getPresenceList(start, end);
    }


}
