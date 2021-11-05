/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.model.Formateur;
import com.OdkApprenant.demo.model.Presence;
import com.OdkApprenant.demo.repositories.ApprenantRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.OdkApprenant.demo.repositories.FormateurRepository;
import com.OdkApprenant.demo.repositories.PresenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class  ServiceImp implements ApprenantService,  FormateurService, PresenceService{
    
    @Autowired
    ApprenantRepository apprenantRepository;

    @Autowired
    FormateurRepository formateurRepository;

    @Autowired
    PresenceRepository presenceRepository;



    @Override
    public Apprenant saveApprenant(Apprenant a) {
        return apprenantRepository.save(a);
    }

    @Override
    public Apprenant updateApprenant(Apprenant a) {
        return apprenantRepository.save(a);
    }

    @Override
    public void deleteApprenant(Apprenant a) {
        apprenantRepository.delete(a);
    }

    @Override
    public void deleteApprenantById(Long id) {
        apprenantRepository.deleteById(id);
    }

    @Override
    public Apprenant getApprenantById(Long id) {
        return apprenantRepository.getById(id);
    }

    @Override
    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();
    }

    @Override
    public Formateur saveFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public Formateur updateFormateur(Formateur formateur) {
        return formateurRepository.save(formateur);
    }

    @Override
    public void deleteFormateur(Formateur formateur) {
        formateurRepository.delete(formateur);
    }

    @Override
    public void deleteFormateurById(Long id) {

        formateurRepository.deleteById(id);
    }

    @Override
    public Formateur getFormateurById(Long id) {
        return formateurRepository.getById(id);
    }

    @Override
    public List<Formateur> getAllFormateur() {
        return formateurRepository.findAll();
    }


    @Override
    public Presence add_to_liste(Presence apprenant) {
        return presenceRepository.save(apprenant);
    }

    @Override
    public void supp_of_liste(Presence apprenant) {
        presenceRepository.delete(apprenant);

    }


    @Override
    public List<Presence> getAllPresence() {
        return presenceRepository.findAll();
    }
}
