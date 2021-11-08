package com.OdkApprenant.demo.services;

import com.OdkApprenant.demo.model.Apprenant;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ApprenantServices {
    private final Map<String, Apprenant> mp;

    public ApprenantServices() {
        this.mp = new ConcurrentHashMap<>();
    }

    public Apprenant lookUp(String login){
        return this.mp.get(login);
    }

    public boolean loginExist(String login){
        return this.mp.containsKey(login);
    }
}
