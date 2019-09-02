package com.scalors.hotels.marryat.services.impl;

import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.hotels.marryat.mapper.RoomMapper;
import com.scalors.hotels.marryat.repository.RoomRepository;
import com.scalors.hotels.marryat.services.RoomService;
import com.scalors.marryat.hotels.entities.rooms.Room;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomMapper roomMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomMapper roomMapper) {
        this.roomRepository = roomRepository;
        this.roomMapper = roomMapper;
    }

    @Override
    public RoomDTO getRoomById(Long roomId) {
        return roomMapper.convertToDTO(
                roomRepository.getOne(roomId));
    }

    @Override
    public void createRoom(RoomDTO roomDTO) {
        roomRepository.save(roomMapper.convertToEntity(roomDTO));
    }

    @Override
    public void updateRoom(RoomDTO roomDTO) {
        roomRepository.save(roomMapper.convertToEntity(roomDTO));
    }

    @Override
    public void deleteRoomById(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public List<Room> getRoomsByRange(Long hotelId, Long roomId, LocalDate startReserveDay, LocalDate finishReserveDay) {
        return roomRepository.getRoomsByRange(hotelId, roomId, startReserveDay, finishReserveDay);
    }


}
