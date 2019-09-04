package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.rooms.RoomTemplateDTO;
import com.scalors.hotels.marryat.services.RoomTemplateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rom-templates")
public class RoomTemplateResource {

    private final RoomTemplateService roomTemplateService;

    public RoomTemplateResource(RoomTemplateService roomTemplateService) {
        this.roomTemplateService = roomTemplateService;
    }

    @PostMapping(produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> createRoom(@RequestBody RoomTemplateDTO request) {
        roomTemplateService.createRoom(request);
        return ResponseEntity.ok().build();

    }

    @PutMapping(produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> updateRoom(@RequestBody RoomTemplateDTO roomTemplateDTO) {
        roomTemplateService.updateRoom(roomTemplateDTO);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping(value = "/{roomId}",
            produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> deleteRoomById(@PathVariable Long roomId) {
        roomTemplateService.deleteRoomById(roomId);
        return ResponseEntity.ok().build();

    }
}
