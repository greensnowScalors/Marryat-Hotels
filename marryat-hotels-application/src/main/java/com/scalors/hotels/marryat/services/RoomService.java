package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.marryat.hotels.entities.rooms.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface RoomService.
 *
 * @author Alexandr Nezhelskyi
 * @version 1.0.
 * 01.09.19
 */
public interface RoomService {

    void addRoom(RoomDTO roomDTO);

    void updateRoom(RoomDTO roomDTO);

    List<Room> getRoomsByRangeAndPaging(Long hotelId, Long roomId, LocalDate startReserveDay, LocalDate finishLocalDate);
}
