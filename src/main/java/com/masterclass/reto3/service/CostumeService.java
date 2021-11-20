/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masterclass.reto3.model.Costume;
import com.masterclass.reto3.repository.CostumeRepository;

@Service
public class CostumeService {
    @Autowired
    private CostumeRepository costumeRepository;
    
    public List<Costume> getAll(){
        return costumeRepository.getAll();
    }
    
    public Optional<Costume> getCostume(int id){
        return costumeRepository.getCostume(id);
    }
    
    public Costume save(Costume c){
        if(c.getId() == 0){
            return costumeRepository.save(c);
        }else{
            Optional<Costume> paux = costumeRepository.getCostume(c.getId());
            if(paux.isEmpty()){
                return costumeRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    public Costume update(Costume c){
        Optional<Costume> caux = costumeRepository.getCostume(c.getId());
        c.setCategory(caux.get().getCategory());
        return costumeRepository.save(c);
    }
    
    public boolean delete(int id){
        Optional<Costume> c = getCostume(id);
        if(!c.isEmpty()){
            costumeRepository.delete(id);
            return true;
        }
        return false;
    }
}
