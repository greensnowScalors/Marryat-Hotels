package com.scalors.hotels.marryat.dto.rooms;

import com.scalors.hotels.marryat.dto.common.BaseDTOId;
import com.scalors.marryat.hotels.entities.hotels.Hotel;
import com.scalors.marryat.hotels.entities.rooms.Reservation;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class RoomDTO extends BaseDTOId {

    private Hotel hotel;

    private String description;

    private List<Reservation> rooms;
}

