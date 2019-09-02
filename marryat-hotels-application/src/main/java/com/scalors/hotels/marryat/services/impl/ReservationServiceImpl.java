package com.scalors.hotels.marryat.services.impl;

import com.scalors.hotels.marryat.dto.reservations.ReservationDTO;
import com.scalors.hotels.marryat.mapper.ReservationMapper;
import com.scalors.hotels.marryat.repository.ReservationRepository;
import com.scalors.hotels.marryat.services.ReservationService;
import com.scalors.marryat.hotels.entities.rooms.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        return reservationMapper.convertToDTO(
                reservationRepository.getOne(id));
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        reservationRepository.deleteById(reservationId);
    }

    @Override
    public void updateReservation(ReservationDTO request) {
        reservationRepository.save(reservationMapper.convertToEntity(request));
    }

    @Override
    public Boolean checkReservation(ReservationDTO request) {
        return reservationRepository.checkReservation(request.getUserId(),
                request.getRoomId(),
                request.getStartReserveDay(),
                request.getEndReserveDay());
    }

    @Override
    public void reservRoom(ReservationDTO request) {
        reservationRepository.save(reservationMapper.convertToEntity(request));
    }

    @Override
    public List<ReservationDTO> getReservatinsByUserId(Long userId) {
        return reservationRepository.getReservatinsByUserId(userId)
                .stream()
                .map(reservationMapper::convertToDTO)
                .collect(Collectors.toList());

    }
}
