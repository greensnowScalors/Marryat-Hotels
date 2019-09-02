package com.scalors.hotels.marryat.repository;

import com.scalors.marryat.hotels.entities.rooms.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select case when (count(r) > 0)  then true else false end from Reservation r " +
            "join r.user u " +
            "join r.room room where u.id = :userId and room.id = :roomId and  " +
            " r.startReserveDay <= (:fromDate) and r.endReserveDay >= (:toDate)")
    Boolean checkReservation(@Param("userId") Long userId, @Param("roomId") Long roomId,
                             @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);


    @Query("select r from Reservation r where r.user.id =:userId")
    List<Reservation> getReservatinsByUserId(@Param("userId") Long userId);

}
