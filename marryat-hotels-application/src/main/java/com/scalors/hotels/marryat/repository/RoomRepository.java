package com.scalors.hotels.marryat.repository;

import com.scalors.marryat.hotels.entities.rooms.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {

    @Query("select case when (count(r) > 0)  then true else false end from Room r " +
            "join r.user u " +
            "join r.room room where u.id = :userId and room.id = :roomId and  " +
            " r.startReserveDay <= (:fromDate) and r.endReserveDay >= (:toDate)")
    Boolean checkReservation(@Param("userId") Long userId, @Param("roomId") Long roomId,
                             @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);


    @Query("select r from Room r where r.user.id =:userId")
    List<Room> getReservatinsByUserId(@Param("userId") Long userId);


    @Query("select r from Room r where r.startReserveDay  between (:fromDate) AND (:toDate)" +
            " OR r.endReserveDay  between (:fromDate) AND (:toDate) ")
    List<Room> getRoomsByDateRange(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);

}
