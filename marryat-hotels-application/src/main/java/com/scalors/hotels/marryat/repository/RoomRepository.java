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

    @Query("select case when (count(r) > 0)  then false else true end from Room r " +
            " where r.roomNumber =:roomNumber and  " +
            "(r.startReserveDay  between (:fromDate) and (:toDate)" +
            " OR r.endReserveDay  between (:fromDate) and (:toDate))")
    Boolean checkReservation(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate,@Param("roomNumber") Long roomNumber);


    @Query("select r from Room r where r.user.id =:userId")
    List<Room> getReservatinsByUserId(@Param("userId") Long userId);


    @Query("select r from Room r join r.room rt where rt.hotel.id =:hotelId and (r.startReserveDay  between (:fromDate) AND (:toDate)" +
            " OR r.endReserveDay  between (:fromDate) AND (:toDate)) ")
    List<Room> getRoomsByDateRange(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate, @Param("hotelId") Long hotelId);

}
