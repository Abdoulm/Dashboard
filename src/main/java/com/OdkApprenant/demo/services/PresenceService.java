package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.model.Formateur;
import com.OdkApprenant.demo.model.Presence;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PresenceService  {

    Presence add_to_liste(Presence apprenant);


    void supp_of_liste(Presence apprenant);

    //List<Presence>  getTodayPresenceListe(String calendar);


    List<Presence> getAllPresence();



}
