package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.rooms.RoomTemplateDTO;

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

}
