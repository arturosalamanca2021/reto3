/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.repository;

import com.masterclass.reto3.model.Costume;
import com.masterclass.reto3.model.Costume;
import com.masterclass.reto3.repository.crud.CostumeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CostumeRepository {
    @Autowired
    private CostumeCrudRepository costumeCrudRepository;
    
    public List<Costume> getAll(){
        return (List<Costume>) costumeCrudRepository.findAll();
    }
    
    public Optional<Costume> getCostume(int id){
        return costumeCrudRepository.findById(id);
    }
    
    public Costume save(Costume p){
        return costumeCrudRepository.save(p);
    }
    
    public void delete(int id){
        costumeCrudRepository.deleteById(id);
    }
}
