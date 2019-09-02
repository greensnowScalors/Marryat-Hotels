package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.hotels.marryat.services.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> createRoom(RoomDTO request) {

        return CompletableFuture
                .runAsync(() -> roomService.createRoom(request))
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping
    public CompletableFuture<ResponseEntity> updateRoom(RoomDTO roomDTO) {

        return CompletableFuture
                .runAsync(() -> roomService.updateRoom(roomDTO))
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{roomId}")
    public CompletableFuture<ResponseEntity> deleteRoomById(@PathVariable Long roomId) {

        return CompletableFuture
                .runAsync(() -> roomService.deleteRoomById(roomId))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public CompletableFuture<ResponseEntity> getRoomsByRangeAndPaging(@RequestParam LocalDate startReserveDay,
                                                                      @RequestParam LocalDate finishReserveDay,
                                                                      @RequestParam Long hotelId,
                                                                      @PathVariable Long roomId) {

        return CompletableFuture
                .supplyAsync(() -> roomService.getRoomsByRange(hotelId, roomId, startReserveDay, finishReserveDay))
                .thenApply(ResponseEntity::ok);
    }


}
