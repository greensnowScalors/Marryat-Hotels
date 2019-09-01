package com.scalors.hotels.marryat.dto.common;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class ReservationPeriod {
    private LocalDate startReserveDay;

    private LocalDate endReserveDay;
}
