package com.scalors.hotels.marryat.services.impl;

import com.scalors.hotels.marryat.dto.rooms.RoomTemplateDTO;
import com.scalors.hotels.marryat.mapper.RoomTemplateMapper;
import com.scalors.hotels.marryat.repository.RoomTemplateRepository;
import com.scalors.hotels.marryat.services.RoomTemplateService;
import com.scalors.marryat.hotels.entities.rooms.RoomTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RoomTemplateServiceImpl implements RoomTemplateService {

    private final RoomTemplateRepository roomTemplateRepository;

    private final RoomTemplateMapper roomTemplateMapper;

    public RoomTemplateServiceImpl(RoomTemplateRepository roomTemplateRepository, RoomTemplateMapper roomTemplateMapper) {
        this.roomTemplateRepository = roomTemplateRepository;
        this.roomTemplateMapper = roomTemplateMapper;
    }

    @Override
    public RoomTemplateDTO getRoomById(Long roomId) {
        return roomTemplateMapper.convertToDTO(
                roomTemplateRepository.findById(roomId).orElse(new RoomTemplate()));
    }

    @Override
    public void createRoom(RoomTemplateDTO roomTemplateDTO) {
        roomTemplateRepository.save(roomTemplateMapper.convertToEntity(roomTemplateDTO));
    }

    @Override
    public void updateRoom(RoomTemplateDTO roomTemplateDTO) {
        roomTemplateRepository.save(roomTemplateMapper.convertToEntity(roomTemplateDTO));
    }

    @Override
    public void deleteRoomById(Long roomId) {
        roomTemplateRepository.deleteById(roomId);
    }

    @Override
    public List<RoomTemplate> getRoomsByRange(Long hotelId, Long roomId, LocalDate startReserveDay, LocalDate finishReserveDay) {
        return null;
//                roomTemplateRepository.getRoomsByRange(hotelId, roomId, startReserveDay, finishReserveDay);
    }


}
