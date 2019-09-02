package com.scalors.hotels.marryat.dto.common;

import lombok.Data;

import java.time.LocalDate;

@Data
public abstract class ReservationPeriod extends BaseDTOId{

    private LocalDate startReserveDay;

    private LocalDate endReserveDay;
}
