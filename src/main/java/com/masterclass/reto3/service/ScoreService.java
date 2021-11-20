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
    
    public List<Score> getAll(){
        return scoreRepository.getAll();
    }
    
    public Optional<Score> getScore(int id){
        return scoreRepository.getScore(id);
    }
    
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
    
    public Score update(Score c){
        return scoreRepository.save(c);
    }
    
    public void delete(int id){
        scoreRepository.delete(id);
    }
    
    
}
