/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masterclass.reto3.repository.crud;

import com.masterclass.reto3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateone, Date dateTwo);
    
    @Query("select c, COUNT(r.id) FROM Client c INNER JOIN c.reservations r GROUP BY c.id ORDER BY COUNT(CASE WHEN r.status = 'completed' THEN 1 ELSE null end) DESC")
    public List<Object[]> findClientMostValued();
    
    @Query(value = "SELECT COUNT(CASE WHEN r.status = 'completed' THEN 1 ELSE null end) as completed, COUNT(case when r.status = 'cancelled' then 1 else null end) as cancelled FROM Reservation r ", nativeQuery = true)
    public Object findCountStatus();
}
