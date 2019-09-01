package com.scalors.hotels.marryat.controllers;

import com.scalors.hotels.marryat.dto.user.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.scalors.hotels.marryat.services.UserService;

import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Async
    @GetMapping("/{userId}")
    public CompletableFuture<ResponseEntity> getUserById(@PathVariable Long userId) {
        return CompletableFuture
                .supplyAsync(() -> userService.getUserById(userId))
                .thenApply(ResponseEntity::ok);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public CompletableFuture<ResponseEntity> addUser(@RequestBody UserDTO userDTO) {
        return CompletableFuture
                .supplyAsync(() -> userService.saveUser(userDTO))
                .thenApply(ResponseEntity::ok);
    }

    @PutMapping
    public CompletableFuture<ResponseEntity> updateUser(@RequestBody UserDTO userDTO) {
        return CompletableFuture
                .supplyAsync(() -> userService.updateUser(userDTO))
                .thenApply(ResponseEntity::ok);
    }

}
