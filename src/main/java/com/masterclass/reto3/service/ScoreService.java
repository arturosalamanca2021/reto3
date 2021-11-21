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
import com.masterclass.reto3.model.Score;
import com.masterclass.reto3.repository.ScoreRepository;


@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;
    
    /**
     * Obtener todos los registros de la tabla score
     * @return 
     */
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    /**
     * obtener un registro de la tabla score filtrado por el campo Id
     * @param id
     * @return 
     */
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
    /**
     * Permite almacenar el registro nuevo en la tabla score
     * @param c
     * @return 
     */
    public Score save(Score c){
        /*if(c.getId() == null){
            return scoreRepository.save(c);
        }else{
            Optional<Score> paux = scoreRepository.getScore(c.getId());
            if(paux.isEmpty()){
                return scoreRepository.save(c);
            }else{
                return c;
            }
        }*/
        return c;
    }
    
    /**
     * Elimina un registro de la tabla score de acuerdo a su id
     * @param id - id del registro 
     * @return  
     */
    public boolean delete(int id){
        Optional<Score> c = getScore(id);
        if(!c.isEmpty()){
            scoreRepository.delete(id);
            return true;
        }
        return false;
    }
    
    
}
