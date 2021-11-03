/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import java.util.List;

/**
 *
 * @author Hady Fofana
 */
public interface ApprenantService {
    Apprenant saveApprenant(Apprenant a);
    
    
    Apprenant updateApprenant(Apprenant a);
    
    
    
    void deleteApprenant(Apprenant a);
    
    
    void deleteApprenantById(Long id);
    
    
    Apprenant getApprenantById(Long id);
    
    
    List<Apprenant> getAllApprenants();
    
    
}
