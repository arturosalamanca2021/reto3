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
import com.masterclass.reto3.model.Reservation;
import com.masterclass.reto3.repository.ReservationRepository;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    /**
     * Obtener todos los registros de la tabla reservations
     * @return 
     */
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    /**
     * obtener un registro de la tabla reservations filtrado por el campo Id
     * @param id
     * @return 
     */
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
    /**
     * Permite almacenar el registro nuevo en la tabla reservations
     * @param c
     * @return 
     */
    public Reservation save(Reservation c){
        if(c.getIdReservation() == 0){
            return reservationRepository.save(c);
        }else{
            Optional<Reservation> paux = reservationRepository.getReservation(c.getIdReservation());
            if(paux.isEmpty()){
                return reservationRepository.save(c);
            }else{
                return c;
            }
        }
    }
    
    /**
     * Actualiza un registro de la tabla reservations
     * @param c
     * @return 
     */
    public Reservation update(Reservation c){
        return reservationRepository.save(c);
    }
    
    /**
     * Elimina un registro de la tabla reservation de acuerdo a su id
     * @param id 
     */
   public boolean delete(int id){
        Optional<Reservation> c = getReservation(id);
        if(!c.isEmpty()){
            reservationRepository.delete(id);
            return true;
        }
        return false;
    }
    
}
