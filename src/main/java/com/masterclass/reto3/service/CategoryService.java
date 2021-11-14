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
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
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
    
    public void delete(int id){
        categoryRepository.delete(id);
    }
}
