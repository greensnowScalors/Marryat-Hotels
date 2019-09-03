package com.scalors.hotels.marryat.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReservationPeriod extends BaseDTOId {

    @JsonProperty("start_reserve_day")
    private LocalDate startReserveDay;

    @JsonProperty("end_reserve_day")
    private LocalDate endReserveDay;

    public ReservationPeriod(Long id, LocalDate startReserveDay, LocalDate endReserveDay) {
        super(id);
        this.startReserveDay = startReserveDay;
        this.endReserveDay = endReserveDay;
    }

}
