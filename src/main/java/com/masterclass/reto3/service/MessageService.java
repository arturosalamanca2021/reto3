/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.service;

import com.masterclass.reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masterclass.reto3.model.Message;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
     /**
     * Obtener todos los registros de la tabla message
     * @return 
     */
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    /**
    * obtener un registro de la tabla message filtrado por el campo Id
    * @param id
    * @return 
    */
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    /**
     * Permite almacenar el registro nuevo en la tabla message
     * @param c
     * @return 
     */
    public Message save(Message c){
        if(c.getIdMessage() == 0){
            return messageRepository.save(c);
        }else{
            Optional<Message> paux = messageRepository.getMessage(c.getIdMessage());
            if(paux.isEmpty()){
                return messageRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    /**
     * Elimina un registro de la tabla message de acuerdo a su id
     * @param id - id del registro 
     * @return  
     */
    public boolean delete(int id){
        Optional<Message> c = getMessage(id);
        if(!c.isEmpty()){
            messageRepository.delete(id);
            return true;
        }
        return false;
    }
}
