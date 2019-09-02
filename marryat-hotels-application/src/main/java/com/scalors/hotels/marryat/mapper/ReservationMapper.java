package com.scalors.hotels.marryat.mapper;

import com.scalors.hotels.marryat.dto.reservations.ReservationDTO;
import com.scalors.hotels.marryat.mapper.common.CommonMapper;
import com.scalors.marryat.hotels.entities.rooms.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper extends CommonMapper<ReservationDTO, Reservation> {

    @Override
    ReservationDTO convertToDTO(Reservation dto);

    @Override
    Reservation convertToEntity(ReservationDTO entity);
}
