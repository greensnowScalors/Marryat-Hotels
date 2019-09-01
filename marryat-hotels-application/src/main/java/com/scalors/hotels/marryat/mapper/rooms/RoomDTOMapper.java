package com.scalors.hotels.marryat.mapper.rooms;

import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.hotels.marryat.mapper.common.CommonMapper;
import com.scalors.marryat.hotels.entities.rooms.Room;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomDTOMapper extends CommonMapper<Room, RoomDTO> {
    @Override
    Room convert(RoomDTO source);
}
