/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.service;

import com.masterclass.reto3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masterclass.reto3.model.Admin;

@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    /**
    * Obtener todos los registros de la tabla admin
    * @return 
    */
    public List<Admin> getAll(){
        return adminRepository.getAll();
    }
    
    /**
     * obtener un registro de la tabla admin filtrado por el campo Id
     * @param id
     * @return 
     */
    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    
    /**
    * Permite almacenar el registro nuevo en la tabla admin
    * @param c
    * @return 
    */
    public Admin save(Admin c){
        if(c.getId() == 0){
            return adminRepository.save(c);
        }else{
            Optional<Admin> paux = adminRepository.getAdmin(c.getId());
            if(paux.isEmpty()){
                return adminRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    /**
     * Elimina un registro de la tabla admin de acuerdo a su id
     * @param id - id del registro 
     * @return  
     */
    public boolean delete(int id){
        Optional<Admin> c = getAdmin(id);
        if(!c.isEmpty()){
            adminRepository.delete(id);
            return true;
        }
        return false;
    }
    
}
