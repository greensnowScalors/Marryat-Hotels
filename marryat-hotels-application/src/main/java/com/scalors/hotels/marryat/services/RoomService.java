package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.reservations.RoomDTO;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {

    RoomDTO getReservationById(Long id);

    void deleteReservationById(Long ReservationId);

    void updateReservation(RoomDTO request);

    Boolean checkReservation(RoomDTO request);

    void reservRoom(RoomDTO request);

    List<RoomDTO> getReservatinsByUserId(Long userId);

    List<RoomDTO> getRoomsByDateRange(LocalDate fromDate, LocalDate toDate);

}
