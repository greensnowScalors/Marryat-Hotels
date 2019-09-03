package com.scalors.hotels.marryat.dto.reservations;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.scalors.hotels.marryat.dto.common.ReservationPeriod;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RoomDTO extends ReservationPeriod {

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("room_id")
    private Long roomId;

    @JsonProperty("comment")
    private String comment;

    @Builder
    public RoomDTO(Long id, LocalDate startReserveDay, LocalDate endReserveDay, Long userId, Long roomId, String comment) {
        super(id, startReserveDay, endReserveDay);
        this.userId = userId;
        this.roomId = roomId;
        this.comment = comment;
    }
}
