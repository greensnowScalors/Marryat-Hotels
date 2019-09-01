package com.scalors.hotels.marryat.controllers;

import com.scalors.hotels.marryat.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{roomId}")
    public CompletableFuture<ResponseEntity> getRoomsByRangeAndPaging(
            @RequestParam LocalDate startReserveDay,
            @RequestParam LocalDate finishReserveDay,
            @RequestParam Long hotelId,
            @PathVariable Long roomId) {

        return CompletableFuture
                .supplyAsync(() -> roomService.getRoomsByRangeAndPaging(hotelId, roomId, startReserveDay, finishReserveDay))
                .thenApply(ResponseEntity::ok);
    }
}
