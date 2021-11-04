package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.model.Formateur;
import com.OdkApprenant.demo.model.Presence;

import java.util.List;

public interface PresenceService  {
    void add_to_liste(Presence apprenant);
    void supp_of_liste(Presence apprenant);

    List<Presence> getAllPresence();



}
