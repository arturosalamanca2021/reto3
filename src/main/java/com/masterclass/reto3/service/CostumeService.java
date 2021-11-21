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
    
    /**
    * Obtener todos los registros de la tabla costume
    * @return 
    */
    public List<Costume> getAll(){
        return costumeRepository.getAll();
    }
    
    /**
     * obtener un registro de la tabla costume filtrado por el campo Id
     * @param id
     * @return 
     */
    public Optional<Costume> getCostume(int id){
        return costumeRepository.getCostume(id);
    }
    
    /**
    * Permite almacenar el registro nuevo en la tabla costume
    * @param c
    * @return 
    */
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
    
    /**
     * Actualiza el registro y asigna id de relación con category
     * @param c
     * @return 
     */
    public Costume update(Costume c){
        Optional<Costume> caux = costumeRepository.getCostume(c.getId());
        c.setCategory(caux.get().getCategory());
        return costumeRepository.save(c);
    }
    
    /**
     * Elimina un registro de la tabla costume de acuerdo a su id
     * @param id - id del registro 
     * @return  
     */
    public boolean delete(int id){
        Optional<Costume> c = getCostume(id);
        if(!c.isEmpty()){
            costumeRepository.delete(id);
            return true;
        }
        return false;
    }
}
