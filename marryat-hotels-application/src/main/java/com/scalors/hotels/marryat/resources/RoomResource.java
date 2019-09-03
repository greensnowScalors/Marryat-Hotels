package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.reservations.RoomDTO;
import com.scalors.hotels.marryat.services.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> reservRoom(RoomDTO request) {

        return CompletableFuture
                .runAsync(() -> roomService.reservRoom(request))
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping
    public CompletableFuture<ResponseEntity> updateReservation(RoomDTO request) {

        return CompletableFuture
                .runAsync(() -> roomService.updateReservation(request))
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{reservationId}")
    public CompletableFuture<ResponseEntity> deleteReservationById(@PathVariable Long reservationId) {

        return CompletableFuture
                .runAsync(() -> roomService.deleteReservationById(reservationId))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/{userId}", produces = "application/json; charset=UTF-8")
    public CompletableFuture<ResponseEntity<RoomDTO>> getReservationId(@PathVariable Long userId) {

        return CompletableFuture
                .supplyAsync(() -> roomService.getReservationById(userId))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/users/{userId}", produces = "application/json; charset=UTF-8")
    public CompletableFuture<ResponseEntity<List<RoomDTO>>> getAllReservationsByUserId(@PathVariable Long userId) {

        return CompletableFuture
                .supplyAsync(() -> roomService.getReservatinsByUserId(userId))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/filter", produces = "application/json; charset=UTF-8")
    public CompletableFuture<ResponseEntity<List<RoomDTO>>> getRoomsByDateRange(@RequestParam("from_date")
                                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                        LocalDate fromDate,
                                                                                @RequestParam("to_date")
                                                                                @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                                        LocalDate toDate) {

        return CompletableFuture
                .supplyAsync(() -> roomService.getRoomsByDateRange(fromDate, toDate))
                .thenApply(ResponseEntity::ok);
    }


}
