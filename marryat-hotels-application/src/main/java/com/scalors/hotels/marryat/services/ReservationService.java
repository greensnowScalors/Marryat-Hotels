package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.reservations.ReservationDTO;

import java.util.List;

public interface ReservationService {

    ReservationDTO getReservationById(Long id);

    void deleteReservationById(Long ReservationId);

    void updateReservation(ReservationDTO request);

    Boolean checkReservation(ReservationDTO request);

    void reservRoom(ReservationDTO request);

    List<ReservationDTO> getReservatinsByUserId(Long userId);

}
