package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.rooms.RoomTemplateDTO;
import com.scalors.hotels.marryat.services.RoomTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/rom-templates")
public class RoomTemplateResource {

    private final RoomTemplateService roomTemplateService;

    public RoomTemplateResource(RoomTemplateService roomTemplateService) {
        this.roomTemplateService = roomTemplateService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> createRoom(RoomTemplateDTO request) {

        return CompletableFuture
                .runAsync(() -> roomTemplateService.createRoom(request))
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping
    public CompletableFuture<ResponseEntity> updateRoom(RoomTemplateDTO roomTemplateDTO) {

        return CompletableFuture
                .runAsync(() -> roomTemplateService.updateRoom(roomTemplateDTO))
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{roomId}")
    public CompletableFuture<ResponseEntity> deleteRoomById(@PathVariable Long roomId) {

        return CompletableFuture
                .runAsync(() -> roomTemplateService.deleteRoomById(roomId))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public CompletableFuture<ResponseEntity> getRoomsByRangeAndPaging(@RequestParam LocalDate startReserveDay,
                                                                      @RequestParam LocalDate finishReserveDay,
                                                                      @RequestParam Long hotelId,
                                                                      @PathVariable Long roomId) {

        return CompletableFuture
                .supplyAsync(() -> roomTemplateService.getRoomsByRange(hotelId, roomId, startReserveDay, finishReserveDay))
                .thenApply(ResponseEntity::ok);
    }


}
