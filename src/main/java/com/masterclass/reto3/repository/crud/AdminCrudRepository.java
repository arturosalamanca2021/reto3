/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.masterclass.reto3.model.Admin;

public interface AdminCrudRepository extends CrudRepository<Admin, Integer>{
    
}
