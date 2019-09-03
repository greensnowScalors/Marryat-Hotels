package com.scalors.hotels.marryat.services.impl;

import com.scalors.hotels.marryat.dto.reservations.RoomDTO;
import com.scalors.hotels.marryat.mapper.RoomMapper;
import com.scalors.hotels.marryat.repository.RoomRepository;
import com.scalors.hotels.marryat.services.RoomService;
import com.scalors.marryat.hotels.entities.rooms.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomDTO getReservationById(Long id) {
        return roomMapper.convertToDTO(
                roomRepository.findById(id).orElse(new Room()));
    }

    @Override
    public void deleteReservationById(Long reservationId) {
        roomRepository.deleteById(reservationId);
    }

    @Override
    public void updateReservation(RoomDTO request) {
        roomRepository.save(roomMapper.convertToEntity(request));
    }

    @Override
    public Boolean checkReservation(RoomDTO request) {
        return roomRepository.checkReservation(request.getUserId(),
                request.getRoomId(),
                request.getStartReserveDay(),
                request.getEndReserveDay());
    }

    @Override
    public void reservRoom(RoomDTO request) {
        roomRepository.save(roomMapper.convertToEntity(request));
    }

    @Override
    public List<RoomDTO> getReservatinsByUserId(Long userId) {
        return roomRepository.getReservatinsByUserId(userId)
                .stream()
                .map(roomMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<RoomDTO> getRoomsByDateRange(LocalDate fromDate, LocalDate toDate) {
        return roomRepository.getRoomsByDateRange(fromDate, toDate)
                .stream()
                .map(roomMapper::convertToDTO)
                .collect(Collectors.toList());
    }
}
