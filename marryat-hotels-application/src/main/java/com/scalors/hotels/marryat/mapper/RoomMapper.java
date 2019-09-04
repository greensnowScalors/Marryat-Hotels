package com.scalors.hotels.marryat.mapper;

import com.scalors.hotels.marryat.dto.reservations.RoomDTO;
import com.scalors.hotels.marryat.mapper.common.CommonMapper;
import com.scalors.marryat.hotels.entities.rooms.Room;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface RoomMapper extends CommonMapper<RoomDTO, Room> {

    @Override
    @Mappings({
            @Mapping(target = "userId", source = "user.id"),
            @Mapping(target = "roomId", source = "room.id")
    })
    RoomDTO convertToDTO(Room entity);

    @Override
    Room convertToEntity(RoomDTO dto);
}
