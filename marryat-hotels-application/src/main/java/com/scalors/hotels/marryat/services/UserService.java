package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.user.UserDTO;

public interface UserService {

    UserDTO getUserById(Long userId);

    void createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUserById(Long userId);

}
