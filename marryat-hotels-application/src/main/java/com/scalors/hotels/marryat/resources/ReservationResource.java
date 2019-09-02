package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.reservations.ReservationDTO;
import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.hotels.marryat.services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/reservations")
public class ReservationResource {

    private final ReservationService reservationService;

    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> reservRoom(ReservationDTO request) {

        return CompletableFuture
                .runAsync(() -> reservationService.reservRoom(request))
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping
    public CompletableFuture<ResponseEntity> updateReservation(ReservationDTO request) {

        return CompletableFuture
                .runAsync(() -> reservationService.updateReservation(request))
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{reservationId}")
    public CompletableFuture<ResponseEntity> deleteReservationById(@PathVariable Long reservationId) {

        return CompletableFuture
                .runAsync(() -> reservationService.deleteReservationById(reservationId))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping("/{userId}")
    public CompletableFuture<ResponseEntity> getReservationsByUserId(@PathVariable Long userId) {

        return CompletableFuture
                .supplyAsync(() -> reservationService.getReservatinsByUserId(userId))
                .thenApply(ResponseEntity::ok);
    }

}
