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
import com.masterclass.reto3.model.Client;
import com.masterclass.reto3.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    /**
    * Obtener todos los registros de la tabla client
    * @return 
    */
    public List<Client> getAll(){
        return clientRepository.getAll();
    }
    
    /**
     * obtener un registro de la tabla client filtrado por el campo Id
     * @param id
     * @return 
     */
    public Optional<Client> getClient(int id){
        return clientRepository.getClient(id);
    }
    
    /**
    * Permite almacenar el registro nuevo en la tabla client
    * @param c
    * @return 
    */
    public Client save(Client c){
        if(c.getIdClient() == 0){
            return clientRepository.save(c);
        }else{
            Optional<Client> paux = clientRepository.getClient(c.getIdClient());
            if(paux.isEmpty()){
                return clientRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    /**
     * Elimina un registro de la tabla client de acuerdo a su id
     * @param id - id del registro 
     * @return  
     */
    public boolean delete(int id){
        Optional<Client> c = getClient(id);
        if(!c.isEmpty()){
            clientRepository.delete(id);
            return true;
        }
        return false;
    }
    
}
