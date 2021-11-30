package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.model.Formateur;

import java.util.List;

public interface FormateurService {


    Formateur saveFormateur(Formateur a);


    Formateur updateFormateur(Formateur a);



    void deleteFormateur(Formateur a);


    void deleteFormateurById(Long id);


    Formateur getFormateurById(Long id);


    List<Formateur> getAllFormateur();


}
