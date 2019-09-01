package com.scalors.hotels.marryat.mapper.rooms;

import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.hotels.marryat.mapper.common.CommonMapper;
import com.scalors.marryat.hotels.entities.rooms.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomMapper extends CommonMapper<RoomDTO, Room> {
    @Override
    RoomDTO convert(Room source);
}
