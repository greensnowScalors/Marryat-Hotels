package com.scalors.hotels.marryat.repository;

import com.scalors.marryat.hotels.entities.rooms.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {


    @Query("select r from Room r join Hotel h join Reservation res where h.id = :hotelId " +
            "and r.id =:roomId and res.startReserveDay between (:startReserveDay) and (:finishLocalDate)")
    List<Room> getRoomsByRange(@Param("hotelId") Long hotelId, @Param("roomId") Long roomId,
                               @Param("startReserveDay") LocalDate startReserveDay, @Param("finishLocalDate") LocalDate finishLocalDate);
}
