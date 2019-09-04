package com.scalors.hotels.marryat.dto.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ReservationPeriod extends BaseDTOId {

    @JsonProperty("start_reserve_day")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startReserveDay;

    @JsonProperty("end_reserve_day")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endReserveDay;

    public ReservationPeriod() {
    }

    public ReservationPeriod(Long id, LocalDate startReserveDay, LocalDate endReserveDay) {
        super(id);
        this.startReserveDay = startReserveDay;
        this.endReserveDay = endReserveDay;
    }
    public ReservationPeriod(Long id, String startReserveDay, String endReserveDay) {
        super(id);
        this.startReserveDay = LocalDate.parse(startReserveDay);
        this.endReserveDay = LocalDate.parse(endReserveDay);
    }

}
