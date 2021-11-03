/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import com.OdkApprenant.demo.repositories.ApprenantRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Hady Fofana
 */
@Service
public class ApprenantServiceImp implements ApprenantService{
    
    @Autowired
    ApprenantRepository apprenantRepository;
    
    
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
    
}
