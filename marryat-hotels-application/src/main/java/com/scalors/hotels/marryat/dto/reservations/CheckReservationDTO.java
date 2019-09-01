package com.scalors.hotels.marryat.dto.reservations;

import com.scalors.hotels.marryat.dto.common.ReservationPeriod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CheckReservationDTO extends ReservationPeriod {
}
