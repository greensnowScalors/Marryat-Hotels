package com.scalors.hotels.marryat.services.impl;

import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.hotels.marryat.mapper.rooms.RoomDTOMapper;
import com.scalors.hotels.marryat.repository.RoomRepository;
import com.scalors.hotels.marryat.services.RoomService;
import com.scalors.marryat.hotels.entities.rooms.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * Class RoomServiceImpl.
 *
 * @author Alexandr Nezhelskyi
 * @version 1.0.
 * 01.09.19
 */
@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    private final RoomDTOMapper dtoMapper;

    public RoomServiceImpl(RoomRepository roomRepository, RoomDTOMapper dtoMapper) {
        this.roomRepository = roomRepository;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public void addRoom(RoomDTO roomDTO) {
        roomRepository.save(dtoMapper.convert(roomDTO));
    }

    @Override
    public void updateRoom(RoomDTO roomDTO) {

    }

    @Override
    public List<Room> getRoomsByRangeAndPaging(Long hotelId, Long roomId, LocalDate startReserveDay, LocalDate finishReserveDay) {

        return roomRepository.getRoomsByRange(hotelId, roomId, startReserveDay, finishReserveDay);
    }


}
