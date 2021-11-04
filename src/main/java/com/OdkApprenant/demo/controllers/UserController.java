/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.controllers;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.model.Formateur;
import com.OdkApprenant.demo.repositories.ApprenantRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.OdkApprenant.demo.repositories.FormateurRepository;
import com.OdkApprenant.demo.services.ApprenantServices;
import com.OdkApprenant.demo.services.ServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    ApprenantRepository apprenantRepo;

    @Autowired
    FormateurRepository formateurRepository;
    
    @Autowired
    ServiceImp serviceImp;

    @Autowired
    ApprenantServices apprenantServices;


    @GetMapping("")
    public String getHomePage(){

        return "index";
    }


    @GetMapping("/all")
    public List<Apprenant> getAllApprenant(){
    List<Apprenant> apprenantList = new ArrayList<Apprenant>();
    Iterable<Apprenant> iterable = serviceImp.getAllApprenants();
    iterable.forEach(apprenantList::add);
    
    return apprenantList;
    }
    

    @PostMapping("/add")
    public Apprenant ajouterApprenant(@RequestBody Apprenant apprenant){
        return serviceImp.saveApprenant(apprenant);
    }
    
    @DeleteMapping("/delete/{id}")
    public void suprimerApprenant(@PathVariable Long id){
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
            apprenant1.setLogin(modifier_apprenant.getLogin());
            apprenant1.setPassword(modifier_apprenant.getPassword());
            apprenant1.setGenre(modifier_apprenant.getGenre());
            apprenant1.setApprenantStatus(modifier_apprenant.getApprenantStatus());
            apprenant1.setDateModification(modifier_apprenant.getDateModification());
            
            apprenant1 = apprenantRepo.save(apprenant1);
            
            return ResponseEntity.ok().body(apprenant1);
        }else {
            return ResponseEntity.notFound().build();
                    
        }
    }


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
}
