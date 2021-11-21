/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.service;

import com.masterclass.reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masterclass.reto3.model.Category;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    /**
    * Obtener todos los registros de la tabla category
    * @return 
    */
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    /**
     * obtener un registro de la tabla category filtrado por el campo Id
     * @param id
     * @return 
     */
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    /**
    * Permite almacenar el registro nuevo en la tabla category
    * @param c
    * @return 
    */
    public Category save(Category c){
        if(c.getId() == 0){
            return categoryRepository.save(c);
        }else{
            Optional<Category> paux = categoryRepository.getCategory(c.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    /**
     * Elimina un registro de la tabla category de acuerdo a su id
     * @param id - id del registro 
     * @return  
     */
    public boolean delete(int id){
        Optional<Category> c = getCategory(id);
        if(!c.isEmpty()){
            categoryRepository.delete(id);
            return true;
        }
        return false;
    }
}
