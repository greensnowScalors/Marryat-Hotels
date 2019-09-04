package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.reservations.RoomDTO;
import com.scalors.hotels.marryat.services.RoomService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping(produces = "application/json",
            consumes = "application/json")
    public ResponseEntity<?> reservRoom(@RequestBody RoomDTO request) {
        roomService.reservRoom(request);
        return ResponseEntity.ok().build();
    }

    @PutMapping(produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> updateReservation(@RequestBody RoomDTO request) {
        roomService.updateReservation(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{reservationId}",
            produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> deleteReservationById(@PathVariable Long reservationId) {
        roomService.deleteReservationById(reservationId);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{userId}",
            produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<RoomDTO> getReservationId(@PathVariable Long userId) {

        return ResponseEntity.ok(roomService.getReservationById(userId));
    }

    @GetMapping(value = "/users/{userId}",
            produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<List<RoomDTO>> getAllReservationsByUserId(@PathVariable Long userId) {

        return ResponseEntity.ok(roomService.getReservatinsByUserId(userId));
    }

    @GetMapping(value = "/filter",
            produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<List<RoomDTO>> getRoomsByDateRange(@RequestParam("from_date")
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                     LocalDate fromDate,
                                                             @RequestParam("to_date")
                                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                                                     LocalDate toDate,
                                                             @RequestParam("hotel_id") Long hotelId) {
        return ResponseEntity.ok(roomService.getRoomsByDateRange(fromDate, toDate, hotelId));
    }

}
