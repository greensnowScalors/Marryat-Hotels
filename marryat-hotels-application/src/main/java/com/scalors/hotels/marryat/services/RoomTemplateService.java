package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.rooms.RoomTemplateDTO;
import com.scalors.marryat.hotels.entities.rooms.RoomTemplate;

import java.time.LocalDate;
import java.util.List;

/**
 * Interface RoomTemplateService.
 *
 * @author Alexandr Nezhelskyi
 * @version 1.0.
 * 01.09.19
 */
public interface RoomTemplateService {

    RoomTemplateDTO getRoomById(Long roomId);

    void createRoom(RoomTemplateDTO roomTemplateDTO);

    void updateRoom(RoomTemplateDTO roomTemplateDTO);

    void deleteRoomById(Long roomId);

    List<RoomTemplate> getRoomsByRange(Long hotelId, Long roomId, LocalDate startReserveDay, LocalDate finishLocalDate);
}
