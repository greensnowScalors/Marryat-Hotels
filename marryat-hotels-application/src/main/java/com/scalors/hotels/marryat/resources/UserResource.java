package com.scalors.hotels.marryat.resources;

import com.scalors.hotels.marryat.dto.user.UserDTO;
import com.scalors.hotels.marryat.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
public class UserResource {

    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> createUser(@RequestBody UserDTO request) {
        userService.createUser(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{userId}",
            produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PutMapping(produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> updateUser(@RequestBody UserDTO request) {
        userService.updateUser(request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{roomId}",
            produces = "application/json; charset=UTF-8",
            consumes = "application/json; charset=UTF-8")
    public ResponseEntity<?> deleteUserById(@PathVariable Long userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();

    }

}
