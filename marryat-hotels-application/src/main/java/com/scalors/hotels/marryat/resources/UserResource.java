package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.rooms.RoomDTO;
import com.scalors.hotels.marryat.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import com.scalors.hotels.marryat.services.UserService;

import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity> createUser(UserDTO request) {

        return CompletableFuture
                .runAsync(() -> userService.createUser(request))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/{userId}", produces = "application/json; charset=UTF-8")
    public CompletableFuture<ResponseEntity> getUserById(@PathVariable Long userId) {
        return CompletableFuture
                .supplyAsync(() -> userService.getUserById(userId))
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping
    public CompletableFuture<ResponseEntity> updateUser(UserDTO request) {

        return CompletableFuture
                .runAsync(() -> userService.updateUser(request))
                .thenApply(ResponseEntity::ok);
    }

    @DeleteMapping("/{roomId}")
    public CompletableFuture<ResponseEntity> deleteUserById(@PathVariable Long userId) {

        return CompletableFuture
                .runAsync(() -> userService.deleteUserById(userId))
                .thenApply(ResponseEntity::ok);
    }

    @GetMapping
    public CompletableFuture<ResponseEntity> getUsers(@RequestParam(name = "limit", required = false, defaultValue = "10") Long limit,
                                                      @RequestParam(name = "offset", required = false, defaultValue = "0") Long offset) {

        return CompletableFuture
                .supplyAsync(() -> userService.getUserList(offset, limit))
                .thenApply(ResponseEntity::ok);
    }


}
