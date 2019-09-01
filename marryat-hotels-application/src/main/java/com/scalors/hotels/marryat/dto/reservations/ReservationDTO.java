package com.scalors.hotels.marryat.dto.reservations;

import com.scalors.hotels.marryat.dto.common.ReservationPeriod;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ReservationDTO extends ReservationPeriod {

    private Long userId;

    private Long roomId;

    private String comment;
}
