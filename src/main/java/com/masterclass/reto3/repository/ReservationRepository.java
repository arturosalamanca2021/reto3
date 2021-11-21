/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.repository;

import com.masterclass.reto3.model.Reservation;
import com.masterclass.reto3.model.Client;
import com.masterclass.reto3.model.CountClients;
import com.masterclass.reto3.model.CountStatus;
import com.masterclass.reto3.repository.crud.ReservationCrudRepository;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    
    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    
    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }
    
    public void delete(int id){
        reservationCrudRepository.deleteById(id);
    }
    
    public List<Reservation> getAllReservationsByDates(Date startDate, Date endDate){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(startDate, endDate);
    }
    
    public List<CountClients> getClientsOrderByCompleteReservations(){
        List<CountClients> res = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.findClientMostValued();
        for (int i = 0; i < report.size(); i++) {
            System.out.println("0 --> " + report.get(i)[0]);
            System.out.println("1 --> " + report.get(i)[1]);
            res.add(new CountClients((long) report.get(i)[1], (Client) report.get(i)[0] ));
        }
        return res;
    } 
    
    public CountStatus getStatusReport(){
        Object[] fields = (Object[]) reservationCrudRepository.findCountStatus();
        
        System.out.println("Este es el objeto: completed - " + fields[0] + " cancelled - " + fields[1]);
        return new CountStatus(((BigInteger)fields[0]).longValue(), ((BigInteger)fields[1]).longValue());
    } 
}
