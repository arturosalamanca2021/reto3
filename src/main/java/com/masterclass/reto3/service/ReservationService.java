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
    
    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    
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
    
    public void delete(int id){
        reservationRepository.delete(id);
    }
    
}
