/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.repository.crud;

import com.masterclass.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author juanc
 */
public interface MessageCrudRepository extends CrudRepository<Message, Integer>{
    
}
