package com.scalors.hotels.marryat.dto.reservations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scalors.hotels.marryat.dto.common.ReservationPeriod;
import com.scalors.marryat.hotels.entities.rooms.Room;
import com.scalors.marryat.hotels.entities.rooms.RoomTemplate;
import com.scalors.marryat.hotels.entities.users.User;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoomDTO extends ReservationPeriod {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("room_id")
    private Long roomId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("room_number")
    private Long roomNumber;

    public RoomDTO() {
    }

    @Builder
    public RoomDTO(Long id, LocalDate startReserveDay, LocalDate endReserveDay, Long userId, Long roomId, String comment, Long roomNumber) {
        super(id, startReserveDay, endReserveDay);
        this.userId = userId;
        this.roomId = roomId;
        this.comment = comment;
        this.roomNumber = roomNumber;
    }

    public Room convertToEntity() {
        Room.RoomBuilder room = Room.builder();

        User user = new User();
        user.setId(this.userId);
        RoomTemplate roomTemplate = new RoomTemplate();
        roomTemplate.setId(this.roomId);
        room.roomNumber(this.roomNumber);
        room.user(user);
        room.room(roomTemplate);
        room.startReserveDay(this.getStartReserveDay());
        room.endReserveDay(this.getEndReserveDay());
        room.comment(this.comment);

        return room.build();
    }

}

