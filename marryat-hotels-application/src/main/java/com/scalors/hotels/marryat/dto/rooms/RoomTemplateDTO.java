package com.scalors.hotels.marryat.dto.rooms;

import com.scalors.hotels.marryat.dto.common.BaseDTOId;
import com.scalors.marryat.hotels.entities.hotels.Hotel;
import com.scalors.marryat.hotels.entities.rooms.Room;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoomTemplateDTO extends BaseDTOId {

    private Hotel hotel;

    private String description;

    private List<Room> rooms;
}

