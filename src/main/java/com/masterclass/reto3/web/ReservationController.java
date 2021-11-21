/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.web;

import com.masterclass.reto3.model.CountClients;
import com.masterclass.reto3.model.CountStatus;
import com.masterclass.reto3.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.masterclass.reto3.model.Reservation;
import java.util.Date;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservation> getReservations(){
        return reservationService.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation p){
        return reservationService.save(p);
    }
    
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveRequest(@RequestBody Reservation p){
        return reservationService.save(p);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation p){
        return reservationService.save(p);
    }
    
    @GetMapping("/report-dates/{startDate}/{endDate}")
    public List<Reservation> getReservationsReport(@PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate){
        return reservationService.getReservationsByDate(startDate, endDate);
    }
    
    @GetMapping("/report-clients")
    public List<CountClients> getClientsReport(){
        return reservationService.getClientsReport();
    }
    
    @GetMapping("/report-status")
    public CountStatus getStatusReport(){
        return reservationService.getStatusReport();
    }
}
