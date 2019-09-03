package com.scalors.hotels.marryat.mapper;

import com.scalors.hotels.marryat.dto.rooms.RoomTemplateDTO;
import com.scalors.hotels.marryat.mapper.common.CommonMapper;
import com.scalors.marryat.hotels.entities.rooms.RoomTemplate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoomTemplateMapper extends CommonMapper<RoomTemplateDTO, RoomTemplate> {
    @Override
    RoomTemplateDTO convertToDTO(RoomTemplate dto);

    @Override
    RoomTemplate convertToEntity(RoomTemplateDTO entity);
}
